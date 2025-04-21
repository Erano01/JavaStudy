package me.erano.com;

import me.erano.com.example1.User;
import me.erano.com.example1.YoutubeChannel;
import me.erano.com.example2.LegacyUser;
import me.erano.com.example2.LegacyYoutubeChannel;
import me.erano.com.example3.BeanYoutubeChannel;
import me.erano.com.example3.BeanUser;
import me.erano.com.example4.FlowUser;
import me.erano.com.example4.FlowYoutubeChannel;
import me.erano.com.spigot.EventBus;
import me.erano.com.spigot.PlayerEventListener;
import me.erano.com.spigot.PlayerJoinEvent;

public class Application {
    // Observable and the Observer interface have been deprecated. The event model supported by Observer and Observable is quite limited,
    // the order of notifications delivered by Observable is unspecified, and state changes are not in one-for-one correspondence
    // with notifications. For a richer event model, consider using the java.beans package.
    // For reliable and ordered messaging among threads, consider using one of the concurrent data structures in the
    // java.util.concurrent package. For reactive streams style programming, see the Flow API.
    public static void main(String[] args) {
        //example 1 -> Simple GoF Observer Design Pattern implementation
        YoutubeChannel channel = new YoutubeChannel("Erano01");
        User ali = new User("Ali");
        User zeynep = new User("Zeynep");
        User ahmet = new User("Ahmet");
        channel.subscribe(ali);
        channel.subscribe(zeynep);
        channel.uploadVideo("Observer Design Pattern Java'da Nasıl Çalışır?");
        channel.unsubscribe(zeynep);
        channel.uploadVideo("Spring Boot ile REST API Geliştirme");
        channel.subscribe(ahmet);
        channel.uploadVideo("Java ile Oyun Geliştirme 101");

        //example 2 -> deprecated simple observer design pattern implementation using: java.util.observable & java.util.observer usage
        /*
        LegacyYoutubeChannel legacyChannel = new LegacyYoutubeChannel("Erano02");
        LegacyUser emre = new LegacyUser("Emre");
        LegacyUser fatma = new LegacyUser("Fatma");
        legacyChannel.addObserver(emre);
        legacyChannel.addObserver(fatma);
        legacyChannel.uploadVideo("Observer Pattern - Deprecated Versiyon");

         */

        //example 3 -> for a richer event model using : java.beans
        /*
        BeanYoutubeChannel beanChannel = new BeanYoutubeChannel("Erano03");
        BeanUser mehmet = new BeanUser("Mehmet");
        BeanUser selin = new BeanUser("Selin");
        beanChannel.subscribe(mehmet);
        beanChannel.subscribe(selin);
        beanChannel.uploadVideo("Java Beans ile Observer Pattern");
         */

        //example 4 -> new observer design pattern implementation using: java.util.concurrent & Flow API
        /*
        FlowYoutubeChannel flowChannel = new FlowYoutubeChannel("Erano04");
        FlowUser elif = new FlowUser("Elif");
        FlowUser mert = new FlowUser("Mert");
        flowChannel.subscribe(elif);
        flowChannel.subscribe(mert);
        flowChannel.uploadVideo("Flow API ile Modern Observer Pattern"); */

        //example 5 -> custom observer design pattern implementation from scratch (+Mediator Pattern implemented)
        // I get inspired from Spigot API -> https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/package-summary.html
        EventBus eventBus = new EventBus();
        eventBus.registerEvents(new PlayerEventListener());

        eventBus.callEvent(new PlayerJoinEvent("EranoMC"));

    }
}
