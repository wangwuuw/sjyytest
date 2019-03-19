package com.test.asycn002;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.test.asycn001.AsyncCall;

public class Demo3{

    private AsyncCall asyncCall = new AsyncCall();
    private final  Object lock = new Object();
    public ArrayList<Future<Long>> call(){
    	ArrayList<Future<Long>> arrayList = new ArrayList<Future<Long>>();
    	Future<Long> future = null;
        for (int i = 0; i < 10; i++) {
        	 future = asyncCall.futureCall();
        	 arrayList.add(future);
		}
        asyncCall.shutdown();
        return arrayList;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	long startTime = System.currentTimeMillis();
        Demo3 demo3 = new Demo3();
        System.out.println("发起调用");
        ArrayList<Future<Long>> futures = demo3.call();
            
        System.out.println("返回结果");
   
        for (int i = 0; i < futures.size(); i++) {
      	  Future<Long> future = futures.get(i);
          while (!future.isDone() && !future.isCancelled());
      	  Long long1 = future.get();
      	  System.out.println("耗时"+long1+"秒");
		}
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("主线程内容");
        long endTime = System.currentTimeMillis();
        long useTime = endTime-startTime;
        System.out.println("使用时间："+useTime);
         

    }
}
