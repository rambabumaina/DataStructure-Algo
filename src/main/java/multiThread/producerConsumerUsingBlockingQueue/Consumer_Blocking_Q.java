package multiThread.producerConsumerUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer_Blocking_Q implements Runnable {

    BlockingQueue<Integer> queue;

    Consumer_Blocking_Q(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("Consumed :" + queue.take());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
