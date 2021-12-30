package multiThreading;

public class Counter {

    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName() + " "+ "Running");
            for (int i =0 ; i < 5 ; i++){
                System.out.println(i);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +" "+ "Stopped");
        };

        Thread t1 = new Thread(runnable,"T1");
//        t1.setDaemon(true);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +" "+ "Stopped");
    }

}

