package me.erano.com.jcip.concurrent.fmentals.sharing;

import net.jcip.annotations.NotThreadSafe;


@NotThreadSafe
public class UnsafePublication {

    // Listing 3.14. Publishing an Object without Adequate Synchronization. Don't Do this
    // Unsafe publication
    public Holder holder;
    public void initialize() {
        holder = new Holder(42);
    }
}
