package multiThreading.threadLifeCycle;

public class WaitAndNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Test T = new Test();

       Thread t1 = new Thread(T,"Thread 1");
       Thread t2 = new Thread(T,"Thread 2");
       Thread t3 = new Thread(T,"Thread 3");

       t1.start();
       t2.start();
       Thread.sleep(1000);
       t3.start();

    }


    private static class Test implements Runnable{

        @Override
        public void run() {
            synchronized (this){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
