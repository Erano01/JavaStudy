package me.erano.com.example2.product;

//Concrete Product
public class VeggieBurger implements Burger{

	public VeggieBurger() {
		System.out.println("Veggie Burger Created");
	}
	
	@Override
	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAddOns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}

	 
}
