package com.example;

/**
 * Created by roro on 2015/6/30.
 */
public class NetRequestWorker implements Runnable {

    private volatile Status mStatus = Status.PENDING;




    public enum Status{
        PENDING,
        RUNNING,
        FINISHED
    }


    @Override
    public void run() {
        //step 1. url
        String url = "http://wwww.baidu.com";

        //step 2. set status

        if (mStatus != Status.PENDING)
            return;

        mStatus = Status.RUNNING;

        //step 3. request




    }
}
