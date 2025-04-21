package me.erano.com.spigot;

import java.lang.reflect.Method;

public class RegisteredListener {
    private final Listener listener;
    private final Method method;

    public RegisteredListener(Listener listener, Method method) {
        this.listener = listener;
        this.method = method;
    }

    public void execute(Event event) {
        try {
            method.invoke(listener, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Class<?> getEventType() {
        return method.getParameterTypes()[0];
    }
}
