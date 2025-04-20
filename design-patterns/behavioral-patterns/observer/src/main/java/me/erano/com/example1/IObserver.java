package me.erano.com.example1;

//Observer ≈ Listener ≈ Subscriber
//IObserver -> Observer
public interface IObserver {
    void update(String message);
}
