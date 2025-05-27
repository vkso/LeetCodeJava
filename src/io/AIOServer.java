package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8080));

        System.out.println("AIO Server started on port 8080");

        // 定义连接完成后的回调
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel clientChannel, Void attachment) {
                serverChannel.accept(null, this); // 继续监听新连接

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                // 异步读取数据
                clientChannel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer bytesRead, ByteBuffer buffer) {
                        if (bytesRead > 0) {
                            buffer.flip();
                            byte[] data = new byte[buffer.remaining()];
                            buffer.get(data);
                            String request = new String(data);
                            // 异步写入回传数据
                            clientChannel.write(ByteBuffer.wrap(("Echo: " + request).getBytes()), buffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result, ByteBuffer attachment) {
                                            buffer.clear();
                                            clientChannel.read(buffer, buffer, this); // 继续读取下一次数据
                                        }
                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {
                                            exc.printStackTrace();
                                        }
                                    });
                        }
                    }
                    @Override
                    public void failed(Throwable exc, ByteBuffer buffer) {
                        exc.printStackTrace();
                    }
                });
            }
            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        // 防止主线程退出
        Thread.currentThread().join();
    }
}
