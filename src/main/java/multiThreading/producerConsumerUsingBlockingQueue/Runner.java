package multiThreading.producerConsumerUsingBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Runner {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

        Producer_Blocking_Q producer = new Producer_Blocking_Q(queue);
        Consumer_Blocking_Q consumer = new Consumer_Blocking_Q(queue);

        Thread producerThread = new Thread(producer,"Producer");
        Thread consumerThread = new Thread(consumer,"Consumer");

        producerThread.start();
        consumerThread.start();

    }
}
