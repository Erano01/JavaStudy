package me.erano.com.example.products;

//Concrete product
public class MotifWindow implements Window{

	@Override
    public void create() {
        System.out.println("Creating a Motif style Window");
    }
}
