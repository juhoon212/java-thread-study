import thread.start.HelloThread;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start!!");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        helloThread.start(); // main 스레드는 내부에 있는 run()을 호출하는것이 아닌 일만 이 스레드에 시키는것.
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end!!");
    }
}