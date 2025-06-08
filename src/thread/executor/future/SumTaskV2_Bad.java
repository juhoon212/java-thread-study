package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class SumTaskV2_Bad {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        final ExecutorService es = Executors.newFixedThreadPool(2);
        // Bad 경우
        // 작업을 한꺼번에 던지지말고 하나씩 던지고 blocking되는 코드를 바로 실행하는경우
        final Future<Integer> future1 = es.submit(task1);
        final Integer sum1 = future1.get(); // 2초

        final Future<Integer> future2 = es.submit(task2);
        final Integer sum2 = future2.get(); // 2초

        log("task1.result = " + sum1);
        log("task2.result = " + sum2);

        int sumAll = sum1 + sum2;
        log("task1 + task2 = " + sumAll);
        log("End");

        es.close();
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");
            Thread.sleep(2000);
            int sum = 0;
            for (int i=startValue; i<=endValue; ++i) {
                sum += i;
            }
            log("작업 완료 result = " + sum);
            return sum;
        }
    }
}
