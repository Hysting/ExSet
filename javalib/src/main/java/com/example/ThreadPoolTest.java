package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by roro on 2015/7/1.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        int CORE_POOL_SIZE = CPU_COUNT + 1;
        int MAXIMUN_POOL_SIZE = CPU_COUNT * 2 + 1;
        int KEEP_ALIVE = 1;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUN_POOL_SIZE,KEEP_ALIVE, TimeUnit.SECONDS,workQueue);










    }
}
