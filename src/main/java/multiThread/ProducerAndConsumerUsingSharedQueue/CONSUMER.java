package multiThread.ProducerAndConsumerUsingSharedQueue;

import java.util.List;

public class CONSUMER implements Runnable {

    private List<Integer> shared_queue;
    boolean flag = true;

    public CONSUMER(List<Integer> shared_queue) {
        this.shared_queue = shared_queue;
    }


    @Override
    public void run() {
        while (flag) {
            try {
                consume();
                Thread.sleep(100);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }


    private void consume(){
        // First synchronized block
        synchronized (shared_queue) {
            while (shared_queue.size()==0) {
                System.out.println("Queue is empty, consumerThread is waiting for "
                        + "producerThread to produce, sharedQueue's size= 0");
                try {
                    shared_queue.wait();
                } catch (InterruptedException e) {
                }
            }
        }

        // second synchronized block
        synchronized (shared_queue){
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
            }
            System.out.println("CONSUMED : "+ shared_queue.remove(0));
            shared_queue.notify(); //Notify producer
        }
    }
}
