package com.lazyxu.network.thread;

public class Synchronized2Demo implements TestDemo {
    private volatile int x = 0;

    private synchronized void count() {
        x++;
//        int temp=x+1;
//        x=temp;//不是原子操作
    }

    @Override
    public void runTest() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 1" + x);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 2" + x);
            }
        }.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
