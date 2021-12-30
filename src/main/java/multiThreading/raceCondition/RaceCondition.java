package multiThreading.raceCondition;

public class RaceCondition implements Runnable {

    int ticket_count = 1;
    @Override
    public void run() {
        System.out.println("Waiting to book ticket for :"+ Thread.currentThread().getName());
        synchronized (this){
            if(ticket_count>0){
                System.out.println("Booking ticket for :"+ Thread.currentThread().getName());

                try{Thread.sleep(2000);}catch (InterruptedException e){}

                ticket_count--;
                System.out.println("Booked ticket :"+ Thread.currentThread().getName());
                System.out.println("currently ticketsAvailable = "+ticket_count);
            }else
            {
                System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("In main : Started");

        RaceCondition race = new RaceCondition();
        Thread t1 = new Thread(race,"Passenger 1");
        t1.start();

        Thread t2 = new Thread(race,"Passenger 2");
        t2.start();

        System.out.println("In main : Ended");

    }
}
