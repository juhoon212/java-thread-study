package thread.bounded;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable{
    private BoundedQueue q;

    public ConsumerTask(BoundedQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        log("[초기 시도]     ? <-" + q);
        String data = q.take();
        log("[소비 완료] " + data + " <- " + q);
    }
}
