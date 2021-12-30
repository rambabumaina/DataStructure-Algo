package multiThreading.deadlock;

public class A implements Runnable {

    @Override
    public void run() {
        synchronized (String.class) {
            System.out.println(Thread.currentThread().getName()+" has acquired lock on "
                    + "Object class and waiting to acquire lock on String class...");

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
