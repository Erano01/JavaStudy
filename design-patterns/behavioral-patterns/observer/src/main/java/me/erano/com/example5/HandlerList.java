package me.erano.com.example5;

import java.util.*;

public class HandlerList {
    private volatile RegisteredListener[] handlers = null;
    private final EnumMap<EventPriority, ArrayList<RegisteredListener>> handlerslots = new EnumMap(EventPriority.class);
    private static ArrayList<HandlerList> allLists = new ArrayList();

    public static void bakeAll() {
        synchronized(allLists) {
            Iterator var1 = allLists.iterator();

            while(var1.hasNext()) {
                HandlerList h = (HandlerList)var1.next();
                h.bake();
            }

        }
    }
    public synchronized void bake() {
        if (this.handlers == null) {
            List<RegisteredListener> entries = new ArrayList();
            Iterator var2 = this.handlerslots.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<EventPriority, ArrayList<RegisteredListener>> entry = (Map.Entry)var2.next();
                entries.addAll((Collection)entry.getValue());
            }

            this.handlers = (RegisteredListener[])entries.toArray(new RegisteredListener[entries.size()]);
        }
    }
}
