package multiThreading.threadLifeCycle;

//Definition :yield() method when called on thread gives a hint to the thread scheduler that the current thread is willing to yield its current use of a processor.
// The thread scheduler is free to ignore this hint.

//Exception : yield() method doesn’t throws any exception.

//Waiting time : yield() method stops thread for unpredictable time.

//Native method : Implementation of yield() method is provided by JVM.

//yield() is a static method, hence calling Thread.yield() causes currently executing thread to yield.

public class YieldMethodExample {
    public static void main(String[] args) {

        MyRunnable1 runnable1 = new MyRunnable1();
        MyRunnable2 runnable2 = new MyRunnable2();

        new Thread(runnable1, "Thread-1").start();
        new Thread(runnable2, "Thread-2").start();
    }

    private static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                //Calling yield Method...
                Thread.yield();
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        }
    }


    private static class MyRunnable2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        }
    }
}
//We observe that the output of the Program is same even calling yield method


