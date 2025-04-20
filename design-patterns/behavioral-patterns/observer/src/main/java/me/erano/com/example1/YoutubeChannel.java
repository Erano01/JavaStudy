package me.erano.com.example1;

import java.util.*;
import java.util.ArrayList;

// Concrete Subject ≈ Publisher ≈ Event ≈ Observable ≈ Event Source
public class YoutubeChannel implements Channel {

    private String name;
    private List<IObserver> subscribers = new ArrayList<>();

    public YoutubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(IObserver subscriber) {
        subscribers.add(subscriber);
        System.out.println(((User) subscriber).getName() + " kanala abone oldu: " + name);
    }

    @Override
    public void unsubscribe(IObserver subscriber) {
        subscribers.remove(subscriber);
        System.out.println(((User) subscriber).getName() + " kanal aboneliğini iptal etti: " + name);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (IObserver subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("\n🎥 " + name + " yeni video yükledi: " + title);
        notifySubscribers(title);
    }
}
