package me.erano.com.example5;

public class EventException extends Exception {
    private static final long serialVersionUID = 3532808232324183999L;
    private final Throwable cause;

    public EventException(Throwable throwable) {
        this.cause = throwable;
    }

    public EventException() {
        this.cause = null;
    }

    public EventException(Throwable cause, String message) {
        super(message);
        this.cause = cause;
    }

    public EventException(String message) {
        super(message);
        this.cause = null;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
