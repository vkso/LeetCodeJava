package Thread;

import java.util.concurrent.Callable;

public class MyCallabe implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 求 1-100 的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
