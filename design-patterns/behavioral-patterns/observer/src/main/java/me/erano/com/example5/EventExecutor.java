package me.erano.com.example5;

import org.jetbrains.annotations.NotNull;

public interface EventExecutor {
    void execute(@NotNull Listener var1, @NotNull Event var2) throws EventException;
}
