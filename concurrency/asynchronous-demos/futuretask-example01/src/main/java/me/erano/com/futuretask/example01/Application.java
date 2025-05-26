package me.erano.com.futuretask.example01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> result = executeAsync();
        System.out.println("Here is the result: "+result.get());
    }

    private static Future<String> executeAsync(){
        return threadPool.submit(()-> {
            executeWorkload("workload1");
            return "<workload result>";
        });
    }

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
