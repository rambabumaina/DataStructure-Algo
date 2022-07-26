package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Volatile_Integer {

  static volatile boolean flag = true;

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        Runnable r = ()->{
            if (flag){
                for (int j = 1; j <= 50; j++) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " Value : " + atomicInteger.getAndIncrement());
                }
            }
        };
    }


    Thread t1 = new Thread();
    Thread t2 = new Thread();
}
