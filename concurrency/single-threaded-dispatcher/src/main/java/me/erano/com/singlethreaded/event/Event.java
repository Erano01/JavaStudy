package me.erano.com.singlethreaded.event;

import org.jetbrains.annotations.NotNull;

//subject, observable, publisher, event
public abstract class Event {

    private String name;
    private final boolean async;

    public Event() {
        this(false);
    }

    public Event(boolean isAsync) {
        this.async = isAsync;
    }

    @NotNull
    public String getEventName() {
        if (this.name == null) {
            this.name = this.getClass().getSimpleName();
        }

        return this.name;
    }

    @NotNull
    public abstract HandlerList getHandlers();

    public final boolean isAsynchronous() {
        return this.async;
    }

    public static enum Result {
        DENY,
        DEFAULT,
        ALLOW;

        private Result() {
        }
    }

}
