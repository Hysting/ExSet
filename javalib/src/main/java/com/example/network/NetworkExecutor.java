package com.example.network;

import java.util.concurrent.BlockingQueue;

/**
 * Created by roro on 2015/7/1.
 */
public class NetworkExecutor extends Thread {

    private BlockingQueue<Request<?>> mRequestQueue;

    private HttpStack mHttpStack;

    private boolean isStop = false;

    public NetworkExecutor(BlockingQueue<Request<?>> mRequestQueue, HttpStack mHttpStack) {
        this.mRequestQueue = mRequestQueue;
        this.mHttpStack = mHttpStack;
    }

    @Override
    public void run() {
        try {
            while (!isStop) {
                Request<?> request = mRequestQueue.take();
                Response response = mHttpStack.performRequest(request);
                System.out.println("----------------------------------");
                System.out.println(response.getResult());
                System.out.println("----------------------------------");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
