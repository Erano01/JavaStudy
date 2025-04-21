package me.erano.com.spigot;

import java.lang.reflect.Method;

//A.K.A PluginManager
public class EventBus {
    public void registerEvents(Listener listener) {
        for (Method method : listener.getClass().getDeclaredMethods()) {
            if (method.getParameterCount() != 1) continue;
            if (!Event.class.isAssignableFrom(method.getParameterTypes()[0])) continue;

            try {
                method.setAccessible(true);
                Class<? extends Event> eventClass = (Class<? extends Event>) method.getParameterTypes()[0];
                HandlerList handlerList = eventClass.getDeclaredConstructor().newInstance().getHandlers();
                handlerList.register(new RegisteredListener(listener, method));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void callEvent(Event event) {
        for (RegisteredListener listener : event.getHandlers().getRegisteredListeners()) {
            if (listener.getEventType().isAssignableFrom(event.getClass())) {
                listener.execute(event);
            }
        }
    }
}
