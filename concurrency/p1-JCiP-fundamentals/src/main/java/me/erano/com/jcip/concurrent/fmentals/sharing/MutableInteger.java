package me.erano.com.jcip.concurrent.fmentals.sharing;

import net.jcip.annotations.NotThreadSafe;

// Listing 3.2. Non-thread-safe Mutable Integer Holder.
@NotThreadSafe
public class MutableInteger {
    private int value;
    public int get() { return value; }
    public void set(int value) { this.value = value; }
}