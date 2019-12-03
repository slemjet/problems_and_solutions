package com.slemjet.questions.other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProducerConsumerTest {
    @Test
    void test() {
        List sharedQueue = new ArrayList();
        int size = 4;
        Thread consThread = new Thread(new ProducerConsumer.Consumer(sharedQueue, size), "Consumer");
        Thread prodThread = new Thread(new ProducerConsumer.Producer(sharedQueue, size), "Producer");
        prodThread.start();
        consThread.start();
    }
}
