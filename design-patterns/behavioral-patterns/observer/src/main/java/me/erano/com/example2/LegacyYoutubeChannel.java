package me.erano.com.example2;

import me.erano.com.example1.IObserver;
import me.erano.com.example1.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

//Concrete Subject ≈ Publisher ≈ Event ≈ Observable ≈ Event Source
public class LegacyYoutubeChannel extends Observable {

    private String name;
    private List<IObserver> subscribers = new ArrayList<>();

    public LegacyYoutubeChannel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title) {
        System.out.println("▶️ (Legacy) Kanal `" + name + "` yeni video yükledi: " + title);
        setChanged();
        notifyObservers(title);
    }
}
