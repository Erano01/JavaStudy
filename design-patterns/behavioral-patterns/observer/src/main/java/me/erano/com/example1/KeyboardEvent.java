package me.erano.com.example1;

import org.jetbrains.annotations.NotNull;

//Concrete Subject, Concrete Event, Concrete Observable, Concrete Publisher
public class KeyboardEvent extends Event{
    private static final HandlerList handlers = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
