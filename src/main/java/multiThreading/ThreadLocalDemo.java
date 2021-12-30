package multiThreading;

public class ThreadLocalDemo {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Ram");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(Thread.currentThread().getName()+ "" + value);
        });


        Thread thread2 = new Thread(() -> {
            threadLocal.set("Babu");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);
        });

        thread1.start();
        thread2.start();
    }
}
