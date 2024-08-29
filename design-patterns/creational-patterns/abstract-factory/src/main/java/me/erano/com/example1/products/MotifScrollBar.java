package me.erano.com.example1.products;

//concrete product
public class MotifScrollBar implements ScrollBar{

	@Override
    public void create() {
        System.out.println("Creating a Motif style ScrollBar");
    }
}
