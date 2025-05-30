package Thread.waitnotify;

public class Desk {
    /**
     * 控制生产者消费者的执行
     */

    // 表示桌子上是否有面条
    public static int foodFlag = 0;

    // 总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();
}
