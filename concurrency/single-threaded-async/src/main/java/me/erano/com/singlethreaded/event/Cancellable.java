package me.erano.com.singlethreaded.event;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean var1);
}
