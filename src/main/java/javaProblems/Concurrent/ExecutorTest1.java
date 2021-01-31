package javaProblems.Concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println("Calling Execute...");
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Invoked Run Method");
            }
        });

        service.shutdown();
    }
}
