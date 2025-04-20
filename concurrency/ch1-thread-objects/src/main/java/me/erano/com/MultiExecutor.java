package me.erano.com;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
    private final List<Thread> taskList;
    //private final List<Runnable> taskList;

    /*
     * @param tasks to be executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        taskList = new ArrayList<>();

        for (Runnable r : tasks) {
            taskList.add(new Thread(r));
        }

        //taskList = new ArrayList<>(tasks);
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    // Some of Thread methods throws InterruptedException for supporting Thread interrupting.(sleep(), join() etc)
    public void executeAll() throws InterruptedException{
        for (Thread thread : taskList) {
            Thread.sleep(1000);
            thread.start();
        }
    }
}
