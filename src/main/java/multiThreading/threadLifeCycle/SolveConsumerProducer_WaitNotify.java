package multiThreading.threadLifeCycle;

import java.util.ArrayList;

//https://www.javamadesoeasy.com/2015/03/wait-and-notify-methods-definition-8.html
public class SolveConsumerProducer_WaitNotify {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Program Start....");
        Producer producer = new Producer();
        new Thread(new Consumer(producer)).start();
        Thread.sleep(100); //just to ensure Consumer start first...
        new Thread(producer).start();
        System.out.println("Program END....");
    }

    private static class Producer implements Runnable {

        ArrayList<Integer> queue;

        Producer() {
            this.queue = new ArrayList<>();
        }

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producer " + Thread.currentThread().getName() + " producing.." + i);
                    queue.add(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Production is over, consumer can consume.");
                this.notify();
            }
        }

    }

    private static class Consumer implements Runnable {
        Producer producer;

        public Consumer(Producer producer) {
            this.producer = producer;
        }

        @Override
        public void run() {
            synchronized (this.producer) {
                if (this.producer.queue.size() <= 10) {
                    try {
                        System.out.println("Consumer " +Thread.currentThread().getName()+" waiting, since producer still producing..");
                        this.producer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while (producer.queue.size() > 0) {
                    System.out.println("Consumer " + Thread.currentThread().getName() + " Consuming " + producer.queue.remove(0));
                }

                }

            }

        }
    }

