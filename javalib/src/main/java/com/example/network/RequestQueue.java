package com.example.network;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by roro on 2015/7/1.
 */
public final class RequestQueue {


    private BlockingQueue<Request<?>> mRequestQueue = new PriorityBlockingQueue<>();

    private AtomicInteger mSerialNumGenerator = new AtomicInteger(0);

    /**
     * 发起一次请求
     * @param request
     */
    public void addRequest(Request<?> request){
        if (!mRequestQueue.contains(request)){
            request.setSerialNum(generateSerialNumber());
            mRequestQueue.add(request);
            NetworkExecutor executor = new NetworkExecutor(mRequestQueue,new HttpUrlConnStack());
            executor.start();
        }
    }

    private int generateSerialNumber(){
        return mSerialNumGenerator.incrementAndGet();
    }

}
