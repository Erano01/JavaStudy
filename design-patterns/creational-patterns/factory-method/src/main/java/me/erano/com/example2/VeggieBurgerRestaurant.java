package me.erano.com.example2;

import me.erano.com.example2.product.Burger;
import me.erano.com.example2.product.VeggieBurger;

//Concrete Creator
public class VeggieBurgerRestaurant extends Restaurant{

	//Overriding factory method
	@Override
	public Burger createBurger() {
		return new VeggieBurger();
	}

	
}
