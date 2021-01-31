package multiThread.executorService;

public class Demo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread th = new Thread(runnable, "OM");
        th.start();

        Thread th1 = new Thread(runnable,"Ram");
        th1.start();

    }
}
