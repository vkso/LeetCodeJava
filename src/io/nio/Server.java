package io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * NIO 非阻塞通信服务端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 获取服务端通道，用于和客户端连接
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // 2. 切换为非阻塞模式
        ssChannel.configureBlocking(false);
        // 3. 绑定连接的端口
        ssChannel.bind(new InetSocketAddress(9999));
        // 4. 获取选择器（一个选择器去轮询多个通道）
        Selector selector = Selector.open();
        // 5. 将服务端通道注册到选择器上，并监听连接
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 使用 Selector 轮询已经就绪好的事件
        while (selector.select() > 0) {  // 没有事件的时候，是阻塞的
            // 7. 获取选择器中所有注册的通道中已经就绪好的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            // 8. 开始遍历这些准备好的事件
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                // 9. 当前事件类型
                if (sk.isAcceptable()) {
                    // 10. 获取当前接入的客户端通道
                    SocketChannel sChannel = ssChannel.accept();  //ServerSocketChannel ssChannel = (ServerSocketChannel) sk.channel();  获取服务端的 channel
                    // 11. 切换为非阻塞模式
                    sChannel.configureBlocking(false);
                    // 12. 将本客户端通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    // 13. 获取当前选择器上读就绪事件
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    // 14. 读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }


    }
}
