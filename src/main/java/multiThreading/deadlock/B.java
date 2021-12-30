package multiThreading.deadlock;

public class B implements Runnable {

    @Override
    public void run() {
        synchronized (Object.class) {
            System.out.println(Thread.currentThread().getName() +
                    " Has acquired the object lock waiting to acquire String lock");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {e.printStackTrace();}

            synchronized (Object.class) {
                System.out.println(Thread.currentThread().getName()+" has acquired "
                        + "lock on Object class");
            }
        }

        System.out.println(Thread.currentThread().getName()+" has ENDED");
    }
}

