package me.erano.com;

public class Application {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Hello world!");
                }

            }
        });
        thread.start();

    }

}
