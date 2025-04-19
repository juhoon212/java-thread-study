package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main start()");

        final Runnable runnable = () -> log("run()");
        Thread thread = new Thread();
        thread.start();

        log("main() end");
    }
}
