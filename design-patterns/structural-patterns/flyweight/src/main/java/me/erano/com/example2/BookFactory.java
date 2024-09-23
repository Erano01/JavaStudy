package me.erano.com.example2;

import java.util.HashMap;
import java.util.Map;

//The Factory manages a pool of existing flyweights, usually consists of a map to cache the values of our flyweights
public class BookFactory {

	private static final Map<String, BookType> bookTypes = new HashMap<>();
	
	public static BookType getBookType(String type, String distributor, String otherData) {
        if (bookTypes.get(type) == null) {
            bookTypes.put(type, new BookType(type, distributor, otherData));
        }
        return bookTypes.get(type);
    }
	
}
