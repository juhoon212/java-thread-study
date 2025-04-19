package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        final Thread myThread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + myThread.getState());
        log("myThread.start()");
        myThread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + myThread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + myThread.getState()); // TERMINATED
        log("end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState()); // RUNNABLE
                log("sleep() start");
                Thread.sleep(3000); // myThread sleep
                log("myThread.state4 = " + Thread.currentThread().getState()); // RUNNABLE
                log("sleep() end");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
