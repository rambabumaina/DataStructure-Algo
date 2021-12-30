package multiThreading.ProducerAndConsumerUsingSharedQueue;

import java.util.List;

public class PRODUCER implements Runnable {

    private List<Integer> shared_queue;
    private int MAX_SIZE = 2; //maximum number of products which sharedQueue can hold at a time.


    public PRODUCER(List<Integer> shared_queue) {
        this.shared_queue = shared_queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            produce(i);
        }
    }


    //Method will get called from run
    private void produce(int i) {

        // First Synchronized block
        synchronized (shared_queue) {
            while (shared_queue.size() == MAX_SIZE) {
                System.out.println("Queue is full, producer is waiting to consume : " + shared_queue.size());
                try {
                    shared_queue.wait();
                } catch (InterruptedException e) {
                }
            }
        }

        // Second Synchronized block
        // By th time consumer consumes products, producer will start producing
        synchronized (shared_queue) {
            System.out.println("Producer is producing, produced : " + i);
            shared_queue.add(i); // adding data to queue
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
            shared_queue.notify();    //notify consumer
        }
    }
}

