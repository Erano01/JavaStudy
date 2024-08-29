package me.erano.com.example1.products;

//concrete product
public class PMScrollBar implements ScrollBar{

	@Override
    public void create() {
        System.out.println("Creating a Presentation Manager style ScrollBar");
    }
}
