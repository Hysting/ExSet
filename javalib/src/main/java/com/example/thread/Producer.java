package com.example.thread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by roro on 2015/7/2.
 */
public class Producer implements Runnable {

    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                queue.put(produce());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Object produce(){
        Object o = new Object();
        System.out.println("produced " + o.toString());
        return o;
    }
}
