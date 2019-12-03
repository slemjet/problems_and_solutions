package com.slemjet.questions.other;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    static class Producer implements Runnable {

        private final List sharedQueue;
        private final int SIZE;

        public Producer(List sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.SIZE = size;
        }

        @Override
        public void run() {
            for (int i = 0; i < 7; i++) {
                System.out.println("Produced: " + i);
                try {
                    produce(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        private void produce(int i) throws InterruptedException {

            //wait if queue is full
            while (sharedQueue.size() == SIZE) {
                synchronized (sharedQueue) {
                    System.out.println("Queue is full " + Thread.currentThread().getName()
                            + " is waiting , size: " + sharedQueue.size());

                    sharedQueue.wait();
                }
            }

            //producing element and notify consumers
            synchronized (sharedQueue) {
                sharedQueue.add(i);
                sharedQueue.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable {

        private final List sharedQueue;
        private final int SIZE;

        public Consumer(List sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.SIZE = size;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Consumed: " + consume());
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        private int consume() throws InterruptedException {
            //wait if queue is empty
            while (sharedQueue.isEmpty()) {
                synchronized (sharedQueue) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName()
                            + " is waiting , size: " + sharedQueue.size());

                    sharedQueue.wait();
                }
            }

            //Otherwise consume element and notify waiting producer
            synchronized (sharedQueue) {
                sharedQueue.notifyAll();
                return (Integer) sharedQueue.remove(0);
            }
        }

    }
}
