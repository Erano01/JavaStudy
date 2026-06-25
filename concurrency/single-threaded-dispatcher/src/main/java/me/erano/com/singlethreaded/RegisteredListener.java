package me.erano.com.singlethreaded;

import me.erano.com.singlethreaded.event.*;
import org.jetbrains.annotations.NotNull;

public class RegisteredListener {
    private final Listener listener;
    private final EventPriority priority;
    //private final Plugin plugin;
    private final Application application;
    private final EventExecutor executor;
    private final boolean ignoreCancelled;

    public RegisteredListener(@NotNull Listener listener, @NotNull EventExecutor executor, @NotNull EventPriority priority, @NotNull Application application, boolean ignoreCancelled) {
        this.listener = listener;
        this.priority = priority;
        //this.plugin = plugin;
        this.application = application;
        this.executor = executor;
        this.ignoreCancelled = ignoreCancelled;
    }

    @NotNull
    public Listener getListener() {
        return this.listener;
    }

    @NotNull
    public Application getApplication() {
        return this.application;
    }

    @NotNull
    public EventPriority getPriority() {
        return this.priority;
    }

    public void callEvent(@NotNull Event event) throws EventException {
        if (!(event instanceof Cancellable) || !((Cancellable)event).isCancelled() || !this.isIgnoringCancelled()) {
            this.executor.execute(this.listener, event);
        }
    }

    public boolean isIgnoringCancelled() {
        return this.ignoreCancelled;
    }
}
