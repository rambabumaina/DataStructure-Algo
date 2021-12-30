package multiThreading.ProducerAndConsumerUsingSharedQueue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MAIN_METHOD {
    public static void main(String[] args) throws IOException {

        List<Integer> shared_queue = new LinkedList<>();//Creating shared object

        PRODUCER producer = new PRODUCER(shared_queue);
        CONSUMER consumer = new CONSUMER(shared_queue);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
