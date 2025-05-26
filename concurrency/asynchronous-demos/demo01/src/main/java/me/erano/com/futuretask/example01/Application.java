package me.erano.com.futuretask.example01;

import java.util.concurrent.*;

public class Application {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> result = executeAsync();
        System.out.println("Here is the result: "+result.get());
        System.out.println("Main thread is still running");
    }

    private static Future<String> executeAsync(){

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        threadPool.submit(()-> {
            executeWorkload("workload1");
            completableFuture.completeExceptionally(new RuntimeException("Workload 1 failed"));
            completableFuture.complete("<workload_result>");
            executeWorkload("workload2");
            System.out.println("Workload 2 completed");
        });

        return completableFuture;
    }

    //
    private static void executeWorkload(String name){
        System.out.println("Executing workload: " + name);
        sleep(3000);
    }

    private static void sleep(long millis) {
        System.out.println("Sleeping for " + millis + " millis");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
