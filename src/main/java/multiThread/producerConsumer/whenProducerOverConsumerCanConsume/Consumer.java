package multiThread.producerConsumer.whenProducerOverConsumerCanConsume;
public class Consumer extends Thread{

    Producer prod;

    Consumer(Producer prod){
        this.prod = prod;
    }

    @Override
    public void run() {

        synchronized (prod){
            System.out.println("Consumer waiting for production to get over.");
            try { this.prod.wait(); } catch (InterruptedException e){}
        }

        /*production is over, consumer will start consuming.*/
        int total_product= prod.shared_list.size();
        System.out.println("Total product to be consumed : "+total_product);

        for (int i =1; i<=total_product;i++){
            System.out.println("Consumed : " + prod.shared_list.remove(0)+ " ");
        }

    }
}
