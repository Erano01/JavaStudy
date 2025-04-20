package me.erano.com;

public class MyCustomThread2 extends Thread{
    @Override
    public void run(){
        System.out.println("We are in thread MyCustomThread2: "+Thread.currentThread().getName());
    }
}
