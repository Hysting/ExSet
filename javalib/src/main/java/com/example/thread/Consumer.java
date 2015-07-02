package com.example.thread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by roro on 2015/7/2.
 */
public class Consumer implements Runnable {

    private final BlockingQueue queue;
    private final String cName;

    public Consumer(BlockingQueue queue, String cName) {
        this.queue = queue;
        this.cName = cName;
    }

    @Override
    public void run() {
        try {
            while(true){
                consume(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void consume(Object x){
        System.out.println( cName + " consumed" + x.toString());
    }
}
