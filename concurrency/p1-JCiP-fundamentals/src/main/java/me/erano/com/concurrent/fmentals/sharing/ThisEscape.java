package me.erano.com.concurrent.fmentals.sharing;

import me.erano.com.concurrent.fmentals.sharing.util.Event;
import me.erano.com.concurrent.fmentals.sharing.util.EventListener;
import me.erano.com.concurrent.fmentals.sharing.util.EventSource;

// Listing 3.7. Implicitly Allowing the this Reference to Escape. Don't Do this
public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {
                    public void onEvent(Event e) {
                        // doSomething(e);
                    }
                });
    }

}
