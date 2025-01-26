package me.erano.com.example1;

import org.jetbrains.annotations.NotNull;

//Concrete Subject, Concrete Event, Concrete Observable, Concrete Publisher
public class MouseEvent extends Event{


    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
