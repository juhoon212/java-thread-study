package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        final Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    spinLock.lock();
                    // critical section
                    log("비즈니스 로직 실행");
                    sleep(1);
                } finally {
                    spinLock.unlock();
                }
            }
        };

        final Thread t1 = new Thread(task, "Thread-1");
        final Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
