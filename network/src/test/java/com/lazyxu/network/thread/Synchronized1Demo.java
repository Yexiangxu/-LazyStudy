package com.lazyxu.network.thread;

import android.os.Looper;

public class Synchronized1Demo implements TestDemo{
    private  volatile boolean running=true;
    private void stop(){
        running=false;
    }
    @Override
    public void runTest() {
        new Thread(){
            @Override
            public void run() {
                if (Thread.interrupted()){//状态从true改为false
                  return;
                }
                if (isInterrupted()){
                    return;
                }

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    //外界调用interrupt，不用等sleep直接出来
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //下面两个方法等价
    private synchronized static void test1(){

    }
    private static void test2(){
        synchronized (Synchronized1Demo.class){

        }
    }
}
