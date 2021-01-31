package multiThread.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorExample {

    public static void main(String[] args) {

        int numberOfThread = 2;
        int tasks = 10;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("executor created with 2 threads.");

        System.out.println("2 threads in executor will be used for executing 10 tasks. "
                + "So, at a time only 2 tasks will be executed");

        for (int i = 1; i <= tasks; i++) {
//            Runnable task = new MyRunnable(i);
//            executor.execute(task);
        }

        executor.shutdown();
        System.out.println("executor has been shutDown.");
    }
}
