package me.erano.com.example2;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Book> books = new ArrayList<>();

    public void storeBook(String name, double price, String type, String distributor, String otherData) {
        BookType bookType = BookFactory.getBookType(type, distributor, otherData);
        books.add(new Book(name, price, bookType));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }

}
