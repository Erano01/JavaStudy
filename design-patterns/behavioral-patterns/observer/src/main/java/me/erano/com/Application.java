package me.erano.com;

public class Application {
    // Observable and the Observer interface have been deprecated. The event model supported by Observer and Observable is quite limited,
    // the order of notifications delivered by Observable is unspecified, and state changes are not in one-for-one correspondence
    // with notifications. For a richer event model, consider using the java.beans package.
    // For reliable and ordered messaging among threads, consider using one of the concurrent data structures in the
    // java.util.concurrent package. For reactive streams style programming, see the Flow API.
    public static void main(String[] args) {
        //example 1 -> custom observer design pattern implementation from scratch (+Mediator Pattern implemented)

        //example 2 -> deprecated observer design pattern implementation using: java.util.observable & java.util.observer usage

        //example 3 -> new observer design pattern implementation using : java.beans

        //example 4 -> new observer design pattern implementation using: java.util.concurrent & Flow API

        //example 5 -> https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/package-summary.html
    }
}
