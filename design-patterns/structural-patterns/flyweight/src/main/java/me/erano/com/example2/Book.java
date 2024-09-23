package me.erano.com.example2;

//Book class is our Context class
//When a context is paired with a flyweight object, it represents the
//full state of the original object
public class Book {
	
	//extrinsic states, this states are unique across all original objects.
	//this is the part that varies, that is unique and maybe altered at runtime
    private final String name;
    private final double price;
    private final BookType type;
    
	public Book(String name, double price, BookType type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public BookType getType() {
		return type;
	}
    
    

}
