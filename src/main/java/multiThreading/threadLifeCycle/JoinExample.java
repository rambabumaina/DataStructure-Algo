package multiThreading.threadLifeCycle;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        Thread t1= new Thread(p,"T1");
        Thread t2= new Thread(p,"T2");
        Thread t3= new Thread(p,"T3");

        System.out.println("Started.....");
        t1.start();
        t2.start();
        t3.start();
        t3.join(); //Here Main thread will wait util t3 is not finished...
        System.out.println("Completed.....");
    }


    private static class Printer implements Runnable{

        @Override
        public void run() {
            for (int i =0 ; i < 3; i++){
                System.out.println("Hello I am "+ Thread.currentThread().getName() +" "+ i);
            }
        }
    }
}
