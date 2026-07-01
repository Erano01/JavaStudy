package me.erano.com.jcip.concurrent.fmentals.safety;


// Listing 2.7. Code that would Deadlock if Intrinsic Locks were Not Reentrant.
public class Widget {
    public synchronized void doSomething() {
    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}

