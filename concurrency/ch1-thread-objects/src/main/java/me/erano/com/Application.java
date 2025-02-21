package me.erano.com;

import java.sql.SQLOutput;

// Concurrency = The structure that allows us to do multitasking.
// Application = The application can consist of a set of processes or the application itself can be a single process
// Process/Context = The instance of the application created in RAM on the HDD or SSD. This instance can contain more than one task.
// Thread = The smallest executable unit in a process.
// Threads share the same memory space within the process and since they are lighter structures, they can be created and managed faster than processes.
// Multitasking can be done both as Process-Based Multitasking and Thread-Based Multitasking.
// Processors can multitask independently of the core and processors can multitask in parallel with more than one core.
// Technologies such as Hyper-Threading or Simultaneous Multithreading (SMT) allow a single physical core to process more than one thread at the same time.
public class Application {

    //main thread
    public static void main(String[] args) throws InterruptedException {

        System.out.println("We are in thread: "+Thread.currentThread().getName());

        //for starting new process -> ProcessBuilder builder = new ProcessBuilder(commandstring);
        //each process in computer has 1 thread at least

        //for starting new thread ->
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in thread0: "+Thread.currentThread().getName());
            }
        });

        //for starting new thread with lambda (Java 8+)
        Thread thread1 = new Thread(() -> {
            System.out.println("We are in thread1: "+Thread.currentThread().getName());
        });

        //Custom threads
        Thread thread2 = new Thread(new MyCustomThread1());
        Thread thread3 = new MyCustomThread2();


        // In Java, even though we write the threads from top to bottom, their execution order is not guaranteed
        // according to the writing order, but since a thread waits for another thread to execute,
        // if we call join after saying thread.start(), we can guarantee this order because the join method allows
        // one thread to wait for the other to complete.
        // so after adding join() methods expecting output is: thread0 > thread1 > thread2 > thread3
        thread0.start();
        thread0.join();

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();

        // To directly control thread creation and management, simply instantiate Thread
        // each time the application needs to initiate an asynchronous task.
        // To abstract thread management from the rest of your application, pass the application's tasks to an executor.

        


    }
}
