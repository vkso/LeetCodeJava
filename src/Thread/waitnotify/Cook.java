package Thread.waitnotify;

public class Cook extends Thread {
    @Override
    public void run() {
        /**
         * 1. 循环
         * 2. 同步代码快
         * 3. 判断共享数据是否到了末尾
         * 4. 判断共享数据没有到末尾的情况
         */
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 判断桌子上是否有食物
                    if (Desk.foodFlag == 1) {
                        // 如果有食物，则等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 如果没有，则制作食物
                        System.out.println("厨师做了一碗面条。");
                        // 修改桌子上的食物状态
                        Desk.foodFlag = 1;
                        // 唤醒等待的消费者开吃
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
