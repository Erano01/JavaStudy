package me.erano.com.singlethreaded;

import me.erano.com.singlethreaded.event.Event;
import me.erano.com.singlethreaded.event.EventException;
import me.erano.com.singlethreaded.event.Listener;
import org.jetbrains.annotations.NotNull;

public interface EventExecutor {
    void execute(@NotNull Listener var1, @NotNull Event var2) throws EventException;
}
