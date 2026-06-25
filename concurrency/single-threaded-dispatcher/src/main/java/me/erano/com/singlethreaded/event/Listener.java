package me.erano.com.singlethreaded.event;

//observer, listener, subscriber
//Simple interface for tagging all EventListeners - Marker interface
public interface Listener {

    //void update(); -> we will use @EventHandler annotation to change this listeners child classes state

    //In the GoF book, the update() method is defined on the Listener, namely the Observer abstract interface.
    // This method changes the states of the child classes of the Listener interface according to the states of the
    // Subjects they subscribe to, namely the states of the Events. However, the mechanism in Bukkit is as follows:
    // You implement the Listener interface in your concrete Listener class, mark your method with the @EventHandler annotation
    // and pass the relevant event as a parameter. I think the Listener interface changes the states of its subclasses
    // elsewhere thanks to this annotation in their methods.
}
