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
        // java.util.ListIterator -> Abstract iterator class that extends Iterator interface.
        // Each Concrete Iterator have decleration in its own aggregate object (inner class)
        List<String> list = new ArrayList<String>();
        list.add("Something1");
        list.add("Something2");
        list.add("Something3");
        // iterator() factory method returns appropriate concrete iterator for that aggregate object
        // in this scenario, ArrayList factory method that returns iterator calls listIterator() on AbstractList
        // and that method returns one of ListIterator<E> iterator implementation that exists in AbstractList (inner class)
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
