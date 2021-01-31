package multiThread.deadlock;

import sun.applet.Main;

public class DeadLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new A(), "A");
        Thread t2 = new Thread(new B(), "B");

        t1.start();
        t2.start();
    }

}
