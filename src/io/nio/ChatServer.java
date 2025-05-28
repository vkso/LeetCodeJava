package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 服务端群聊系统
 */
public class ChatServer {
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT = 9999;

    public ChatServer() {
        try {
            selector = Selector.open();
            ssChannel = ServerSocketChannel.open();
            ssChannel.bind(new InetSocketAddress(PORT));
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.listen();
    }

    /**
     * 开始监听
     */
    private void listen() {
        while (true) {
            try {
                if (!(selector.select() > 0)) break;

                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {
                        SocketChannel sChannel = ssChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        readClientData(sk);
                    }
                    it.remove();  // 移除当前事件
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 接收当前客户端通道的信息，转发给其他全部客户端通道
     * @param sk
     */
    private void readClientData(SelectionKey sk) {
        SocketChannel sChannel = null;
        sChannel= (SocketChannel) sk.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int count = sChannel.read(buffer);
            if (count > 0) {
                buffer.flip();
                String msg = new String(buffer.array(), 0, buffer.remaining());
                System.out.println("接收到客户端的消息：" + msg);

                sendMsgToAllClient(msg, sChannel);
            }
        } catch (Exception e) {
            // 离线的时候，read 读不到数据，会抛出异常
            try {
                System.out.println("有客户端下线: " + sChannel.getRemoteAddress());
                sk.cancel();
                sChannel.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * 把当前客户端的消息，推送给全部在线并注册的 Channel
     * @param msg
     * @param sChannel
     */
    private void sendMsgToAllClient(String msg, SocketChannel sChannel) {
        System.out.println("服务端开始转发消息，当前处理的线程是：" + Thread.currentThread().getName());
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            // 判断是不是自己的通道
            if (channel instanceof SocketChannel && channel != sChannel) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                try {
                    ((SocketChannel) channel).write(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
