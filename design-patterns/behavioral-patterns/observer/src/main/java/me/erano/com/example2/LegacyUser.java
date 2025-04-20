package me.erano.com.example2;

import java.util.Observable;
import java.util.Observer;

//Concrete Observer ≈ Listener ≈ Subscriber
public class LegacyUser implements Observer {
    private String name;

    public LegacyUser(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("(Legacy) " + name + ", yeni video geldi: " + arg);
    }
}
