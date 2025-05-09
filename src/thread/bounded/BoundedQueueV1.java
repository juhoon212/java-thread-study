package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue{

    private final Queue<String> q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (q.size() == max) {
            log("[put] 큐가 가득 참, 버림 " + data);
            return;
        }
        q.offer(data);
    }

    @Override
    public synchronized String take() {
        if (q.isEmpty()) {
            return null;
        }
        return q.poll();
    }

    @Override
    public String toString() {
        return q.toString();
    }
}
