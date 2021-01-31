package multiThread.executorService;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i =0 ; i< 10 ;i++){
            System.out.println(Thread.currentThread().getName());
            try{Thread.sleep(2000);}catch (InterruptedException e){}
        }
    }
}
