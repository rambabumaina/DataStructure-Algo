package multiThreading.volatile_syncronized;

public class VolatileExample {

    static int x = 0, y = 0;

    static synchronized void method1() {
        x++;
        y++;
    }

    static synchronized void method2() {
        System.out.println("x=" + x + " y=" + y);
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for(int i=0; i<10;i++)
                method1();
        });

        Thread t2 = new Thread(()->{
            for(int i=0; i<10;i++)
                method2();
        });

        t1.start();
        t2.start();
    }

}
