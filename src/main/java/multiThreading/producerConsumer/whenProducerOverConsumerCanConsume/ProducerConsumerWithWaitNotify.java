package multiThreading.producerConsumer.whenProducerOverConsumerCanConsume;

public class ProducerConsumerWithWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Producer p = new Producer();
        Consumer c = new Consumer(p);

        Thread p_th = new Thread(p,"Producer");
        Thread c_th = new Thread(c, "Consumer");

        //Start Consumer thread first

        c_th.start();

        Thread.sleep(2000);

        p_th.start();

    }
}
