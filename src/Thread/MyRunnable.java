package Thread;

public class MyRunnable implements Runnable {
    int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
        }
    }

    private synchronized boolean extracted() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (ticket == 100) {
            return true;
        } else {
            ticket++;
            System.out.println(Thread.currentThread().getName() + " 正在卖第" + ticket +"张票！");
        }
        return false;
    }
}
