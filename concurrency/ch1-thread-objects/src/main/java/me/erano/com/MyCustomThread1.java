package me.erano.com;

//this idiom is better than extending Thread class.
public class MyCustomThread1 implements Runnable{

    // Some of Thread methods throws InterruptedException for supporting Thread interrupting.(sleep(), join() etc)
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("We are in thread MyCustomThread1: "+Thread.currentThread().getName());
        } catch (InterruptedException exception) { // for supporting interruption if we had sleep() in try blcok
            throw new RuntimeException(exception);
        }
    }


}
