package me.erano.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Application {

    public static void main(String[] args) {
        // java.util.List -> Aggregate interface
        // java.util.ArrayList -> Concrete Aggregate Class
        // java.util.Iterator -> Iterator interface (declares hasNext(), next(), remove())
        // java.util.ListIterator -> Concrete iterator class that extends Iterator

        List<String> list = new ArrayList<String>();
        list.add("Something1");
        list.add("Something2");
        list.add("Something3");
        // iterator() factory method returns appropriate concrete iterator for that aggregate object
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
