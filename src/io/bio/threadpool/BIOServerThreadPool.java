package io.bio.threadpool;

import java.net.ServerSocket;
import java.net.Socket;

public class BIOServerThreadPool {
    public static void main(String[] args) {
        try {
            // 注册端口
            ServerSocket ss = new ServerSocket(8080);
            // 定义一个循环接收客户端的 Socket 链接请求
            // 初始化一个线程池对象
            HandlerSocketServerPool pool = new HandlerSocketServerPool(3, 10);
            while (true) {
                Socket socket = ss.accept();
                // 把 socket 对象交给一个线程池进行处理
                // 把 socket 封装成一个任务对象交给线程池处理
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
