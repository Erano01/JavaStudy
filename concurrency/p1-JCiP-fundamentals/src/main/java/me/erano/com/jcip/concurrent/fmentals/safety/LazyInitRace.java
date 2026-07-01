package me.erano.com.jcip.concurrent.fmentals.safety;

import net.jcip.annotations.NotThreadSafe;

// Listing 2.3. Race Condition in Lazy Initialization. Don't Do this.
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }

    // Example of an expensive object that takes time to create
    class ExpensiveObject {
        // Simulate an expensive object creation
        public ExpensiveObject() {
            try {
                Thread.sleep(1000); // Simulate time-consuming initialization
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
