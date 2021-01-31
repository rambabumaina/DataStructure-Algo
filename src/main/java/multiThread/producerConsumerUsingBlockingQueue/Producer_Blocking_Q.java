package multiThread.producerConsumerUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer_Blocking_Q implements Runnable{

    private BlockingQueue<Integer> queue;

    Producer_Blocking_Q(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
            for (int i =1 ; i<=20; i++){
                System.out.println("Produced :"+ i);

                try {
                    Thread.sleep(2000);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
