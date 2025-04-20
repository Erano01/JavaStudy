package me.erano.com.example3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BeanYoutubeChannel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String name;

    public BeanYoutubeChannel(String name) {
        this.name = name;
    }

    public void subscribe(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("▶️ (Legacy) Kanal `" + name + "` yeni video yükledi: " + videoTitle);
        support.firePropertyChange("video", null, videoTitle);
    }
}
