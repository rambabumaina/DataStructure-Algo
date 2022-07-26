package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_Integer {

//Atomic integer synchronized by default
//Increment counter using multiple threads

//https://howtodoinjava.com/java/multi-threading/atomicinteger-example/

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread " + Thread.currentThread().getName() + " Value : " + atomicInteger.getAndIncrement());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");

        t1.start();
        t2.start();
    }
}
