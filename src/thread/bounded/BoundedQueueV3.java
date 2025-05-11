package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue{

    private Queue<String> q = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (q.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            try {
                wait(); // RUNNABLE -> WAITING, 락 반납
                log("[PUT] 생산자 꺠어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e); 
            }
        }
        q.offer(data);
        log("[PUT] 생산자 데이터 저장, notify() 호출");
        notify(); // 대기 스레드, WAITING -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (q.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = q.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // 대기 스레드, WAITING -> BLOCKED
        return data;
    }

    @Override
    public String toString() {
        return q.toString();
    }
}
