package com.example.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by roro on 2015/7/2.
 */
public class SetUp {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque();
        Producer producer = new Producer(queue);
        Consumer c1 = new Consumer(queue,"c1");
        Consumer c2 = new Consumer(queue,"c2");
        new Thread(producer).start();
//        new Thread(c1).start();
//        new Thread(c2).start();
    }
}
