package multiThreading.threadLifeCycle;

//https://javagoal.com/notify-method-in-java/
public class PrinterMachine_WaitNotify {
    public static void main(String[] args) {

        Printer p = new Printer();

        new Thread(p::printPages).start();
        new Thread(p::printPagesWithWait).start();
//        new Thread(() -> p.addPages(100)).start();
    }



    private static class Printer{
        int noOfPages = 0;

        //Wait method with timeout
        public synchronized void printPagesWithWait(){
            System.out.println("Name:"+ Thread.currentThread().getName());
            System.out.println("before called notify() method number of Paper : " +    this.noOfPages);

            if(noOfPages <= 100){
                System.out.println("pages are less then 100, please wait...");
                try {
                    System.out.println("Waiting...");
                    wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Name:"+ Thread.currentThread().getName());
            System.out.println("After called notify() method number of Paper : " +    this.noOfPages);
            System.out.println("please collect your prints...");
        }


        public synchronized void printPages(){
            System.out.println("Name:"+ Thread.currentThread().getName());
            System.out.println("before called notify() method number of Paper : " +    this.noOfPages);

            if(noOfPages <= 100){
                System.out.println("pages are less then 100, please wait...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Name:"+ Thread.currentThread().getName());
            System.out.println("After called notify() method number of Paper : " +    this.noOfPages);
            System.out.println("please collect your prints...");
        }

        public synchronized void addPages(int page){
            System.out.println("Name:"+ Thread.currentThread().getName());
                noOfPages +=page;
                notify();
        }
    }
}
