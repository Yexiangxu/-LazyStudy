package com.lazyxu.network.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    @Test
    public void main() {
//     new Synchronized1Demo().runTest();
        new Synchronized2Demo().runTest();
        try {
            new Thread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void callback() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Done";
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(callable);
        while (true) {
            if (future.isDone()) {
                try {
                    String result = future.get();
                    System.out.println("result:" + result);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
