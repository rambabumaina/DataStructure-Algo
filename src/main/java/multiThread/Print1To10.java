package multiThread;

public class Print1To10 {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
       Thread t1 = new Thread(myThread);
       Thread t2 = new Thread(myThread);

       t1.start();
       t2.start();

    }
}


class MyThread implements Runnable{

    @Override
    public void run() {
        synchronized (MyThread.class){
        for (int i =0 ; i < 10 ;i ++){
                System.out.println(Thread.currentThread().getName() + " printed " + i);
            }
        }
    }
}
