package com.test.asycn001;
public class Demo1{
    private final Object lock = new Object();
    public void callback(long response) {
        System.out.println("得到结果"+response);
        System.out.println("调用结束");
        synchronized (lock) {
            lock.notifyAll();
        }
    }
    protected AsyncCall asyncCall = new AsyncCall();
    public void call(){
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }
    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 10; i++) {
            demo1.call();
            synchronized (demo1.lock){
                try {
                    demo1.lock.wait();
                  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
          
		}
        System.out.println("主线程内容");
        long endTime = System.currentTimeMillis();
        long useTime = endTime-startTime;
        System.out.println("使用时间："+useTime);
//        System.out.println("主线程内容");
    }
}
