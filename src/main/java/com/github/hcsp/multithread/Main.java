package com.github.hcsp.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Void> f1 =
                executorService.submit(
                        new Callable<Void>() {
                            @Override
                            public Void call() throws Exception {
                                System.out.println("start f1");

                                Future<Void> f2 =
                                        executorService.submit(
                                                new Callable<Void>() {
                                                    @Override
                                                    public Void call() {
                                                        System.out.println("start f2");
                                                        return null;
                                                    }
                                                });

                                f2.get();

                                System.out.println("end f1");
                                return null;
                            }
                        });

        f1.get();
    }
}
