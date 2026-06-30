package me.erano.com.mcij.concurrent;

public class ThreadCreationDemo {

    public static void main(String[] args) {

        // Extending Thread class
        Thread t1 = new ThreadByExtension("Worker-1");
        t1.start();

        // Implementing Runnable (classic)
        Thread t2 = new Thread(
                new RunnableImplementation(), "Worker-2");
        t2.start();

        // Anonymous inner class (Java 1.1)
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous: " +
                        Thread.currentThread().getName());
            }
        }, "Worker-3");
        t3.start();

        // Lambda expression (Java 8)
        Thread t4 = new Thread(() ->
                System.out.println("Lambda: " +
                        Thread.currentThread().getName()),
                "Worker-4");
        t4.start();
    }
}

class ThreadByExtension extends Thread {
    public ThreadByExtension(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Extended Thread: " + getName());
    }
}

class RunnableImplementation implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable: " +
                Thread.currentThread().getName());
    }
}