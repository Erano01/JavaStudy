package me.erano.com.jcip.concurrent.fmentals.sharing;

import me.erano.com.concurrent.fmentals.sharing.util.*;
import me.erano.com.jcip.concurrent.fmentals.sharing.util.Event;
import me.erano.com.jcip.concurrent.fmentals.sharing.util.EventListener;
import me.erano.com.jcip.concurrent.fmentals.sharing.util.EventSource;

// Listing 3.8. Using a Factory Method to Prevent the this Reference from Escaping During Construction.
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e) {
                // doSomething(e);
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }
}
