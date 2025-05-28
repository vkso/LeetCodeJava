package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 客户端实现基于 NIO 的非阻塞通信
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 获取客户端的通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("localhost", 9999));
        // 2. 切换非阻塞模式
        sChannel.configureBlocking(false);
        // 3. 分配指定缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 4. 发送数据给服务端
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要发送的数据：");
            String msg = sc.nextLine();
            buf.put(msg.getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
    }
}
