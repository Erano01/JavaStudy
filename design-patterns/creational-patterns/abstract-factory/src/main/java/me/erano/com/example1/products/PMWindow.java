package me.erano.com.example1.products;

//concrete product
public class PMWindow implements Window{

	@Override
    public void create() {
        System.out.println("Creating a Presentation Manager style Window");
    }
}
