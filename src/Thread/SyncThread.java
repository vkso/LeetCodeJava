package Thread;

public class SyncThread extends Thread {
    static int ticket = 0;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {  // 也可以使用当前类的字节码文件 SyncThread.class，该文件是唯一的
                if (ticket < 1000) {
                    ticket++;
                    System.out.println(getName() +  "正在卖第" + ticket + "张票！！！");
                } else {
                    break;
                }
            }
        }
    }
}
