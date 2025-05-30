package Thread.waitnotify;

public class Foodie extends Thread{
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
                    // 先去判断桌子上是否有面条
                    if (Desk.foodFlag == 0) {
                        try {
                            // 如果没有，等待
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 如果有，就开吃
                        // 把吃的总数 - 1
                        Desk.count--;
                        System.out.println("正在吃面条，还能再吃 " + Desk.count + "碗。");
                        // 吃完之后，唤醒厨师继续做
                        Desk.lock.notifyAll();
                        // 修改桌子的状态
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
