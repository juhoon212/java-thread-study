package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionMain {

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        final Future<Integer> future = es.submit(new ExCallable());
        sleep(1000); // 잠시 대기

        try {
            log("Future get() 호출 시도, future.state(): " + future.state());
            final Integer result = future.get();
            log("result value = " + result);
        } catch (ExecutionException e) {
            log("e = " + e);
            final Throwable cause = e.getCause(); // 원본 예외
            log("cause = " + cause);
        }
        es.close();
    }

    static class ExCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}
