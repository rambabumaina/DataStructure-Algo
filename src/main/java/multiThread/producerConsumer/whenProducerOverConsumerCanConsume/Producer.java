package multiThread.producerConsumer.whenProducerOverConsumerCanConsume;

import java.util.LinkedList;
import java.util.List;

public class Producer implements Runnable{
    List<Integer> shared_list;

    Producer(){
        shared_list = new LinkedList<>();
    }

    @Override
    public void run() {

        synchronized (this){

            for (int i=1; i<=10;i++){
                System.out.println("Producer is producing, Produced :"+ i);
                shared_list.add(i);
                try{ Thread.sleep(1000);}catch (InterruptedException e){}
            }

            System.out.println("Production completed consumers can consume....");
            notify(); //Production is over, notify consumer thread so that consumer can consume.

        }
    }
}
