package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        // main thread
        final Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread); // 내부적으로 toString() 호출 -> threadId, name, priority, threadGroup
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.getThreadGroup = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState()); // NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

        // my thread
        final Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());
        log("myThread.getThreadGroup = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());
    }
}
