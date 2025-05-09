package thread.bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable{

    private BoundedQueue q;
    private String request;

    public ProducerTask(BoundedQueue q, String request) {
        this.q = q;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + q);
        q.put(request);
        log("[생산 완료] " + request + " -> " + q);
    }
}
