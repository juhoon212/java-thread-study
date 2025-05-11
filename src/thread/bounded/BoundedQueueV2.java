package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue{

    private Queue<String> q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (q.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            sleep(1000); // 락 가지고 무한 반복
        }
        q.offer(data);
    }

    @Override
    public synchronized String take() {
        while (q.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            sleep(1000);
        }
        return q.poll();
    }

    @Override
    public String toString() {
        return q.toString();
    }
}
