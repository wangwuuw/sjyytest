package com.test.asycn001;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class AsyncCall {

    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService tp = Executors.newFixedThreadPool(10);

    //demo1,2,4,5调用方法
    public void call(Demo1 demo){

        new Thread(()->{
            long res = random.nextInt(10);

            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           System.out.println("等待时间："+res*1000);
            demo.callback(res);
        }).start();


    }

    //demo3调用方法
    public Future<Long> futureCall(){
        return tp.submit(()-> {
            long res = random.nextInt(10);
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName());
            try {
                Thread.sleep(res*1000);
                System.out.println("等待时间："+res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });

    }

    public void shutdown(){

        tp.shutdown();

    }

}

