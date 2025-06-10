package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = false; // 변경

    public static void main(String[] args) {
        final ExecutorService es = Executors.newFixedThreadPool(1);
        final Future<String> future = es.submit(new MyTask());
        log("Future.state: " + future.state());

        // 일정 시간 후 취소 시도
        sleep(3000);

        // cancel() 호출
        log("future.cancel(" + mayInterruptIfRunning + ") 호출");
        // cancel(true) 면 취소 상태로 변경, interrupt를 호출해서 작업 중단
        // cacnel(false) 면 작업중인 task는 중단하지 않는다.
        final boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log("cacnel(" + mayInterruptIfRunning + ") result : " + cancelResult);

        // 결과 확인
        try {
            log("Future result: " + future.get());
        } catch (CancellationException e) {
            log("Future는 이미 취소되었습니다.");
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
                try {
                    for (int i=0; i<10; ++i) {
                        log("작업중: " + i);
                        Thread.sleep(1000); // 1초 동안 sleep
                    }
                } catch (InterruptedException e) {
                    log("인터럽트 발생");
                    return "Interrupted";
                }

            return "Completed";
        }
    }
}
