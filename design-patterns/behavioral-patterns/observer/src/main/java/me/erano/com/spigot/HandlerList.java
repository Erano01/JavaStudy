package me.erano.com.spigot;

import java.util.ArrayList;
import java.util.List;

public class HandlerList {
    private final List<RegisteredListener> listeners = new ArrayList<>();

    public void register(RegisteredListener listener) {
        listeners.add(listener);
    }

    public List<RegisteredListener> getRegisteredListeners() {
        return listeners;
    }
}
