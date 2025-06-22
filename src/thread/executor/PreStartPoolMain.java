package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.executor.ExecutorUtils.printState;
import static util.ThreadUtils.sleep;

public class PreStartPoolMain {

    public static void main(String[] args) {
        final ExecutorService es = Executors.newFixedThreadPool(1000);
        printState(es);
        final ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads(); // 먼저 스레드를 풀에 만들어 놓는다. -> 사용자가 급격히 들어올때 작업이 들어올떄 스레드를 생산하는 것이 아닌 미리 만들어 놓는다.
        sleep(100);
        printState(es);
        es.close();
    }
}
