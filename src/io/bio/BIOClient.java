package io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        // 创建 socket 对象请求服务端的连接
        Socket socket = new Socket("localhost", 8080);
        // 从 Socket 对象中获取一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        // 把字节输出流包装成一个打印流
        PrintStream ps = new PrintStream(outputStream);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入消息内容：");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}
