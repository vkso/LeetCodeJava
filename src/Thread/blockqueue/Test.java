package Thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {

    public static void main(String[] args) {
        // 1. 创建阻塞队列对象
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        // 2. 创建线程对象，并把阻塞队列传递进去
        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);

        // 3. 开启线程
        cook.start();
        foodie.start();
    }
}
