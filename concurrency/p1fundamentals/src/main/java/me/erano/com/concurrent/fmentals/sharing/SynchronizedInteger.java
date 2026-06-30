package me.erano.com.concurrent.fmentals.sharing;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

// Listing 3.3. Thread-safe Mutable Integer Holder.
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
