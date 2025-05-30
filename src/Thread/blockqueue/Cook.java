package Thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            // 不断的将面条放入到阻塞队列中
            try {
                queue.put("面条");
                System.out.println("厨师放了面条。");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
