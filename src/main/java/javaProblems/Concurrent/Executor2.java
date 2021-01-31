package javaProblems.Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Object> future = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Callable called...");
                return "Returned result";
            }
        });
        
        System.out.println(future.get());
        service.shutdown();

        System.out.println(future.isDone());
    }
}
