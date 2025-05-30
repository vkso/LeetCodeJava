package Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newCachedThreadPool();
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.shutdown();;
    }
}
