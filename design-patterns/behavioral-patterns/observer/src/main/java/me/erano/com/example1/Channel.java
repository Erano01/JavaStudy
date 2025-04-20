package me.erano.com.example1;

//Subject ≈ Publisher ≈ Event ≈ Observable ≈ Event Source
//Channel = Subject
public interface Channel {
    void subscribe(IObserver subscriber);
    void unsubscribe(IObserver subscriber);
    void notifySubscribers(String videoTitle);
}
