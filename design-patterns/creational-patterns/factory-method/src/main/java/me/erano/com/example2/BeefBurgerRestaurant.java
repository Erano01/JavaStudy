package me.erano.com.example2;

import me.erano.com.example2.product.BeefBurger;
import me.erano.com.example2.product.Burger;

//Concrete Creator
public class BeefBurgerRestaurant extends Restaurant{

	//Overriding factory method
	@Override
	public Burger createBurger() {
		return new BeefBurger();
	}

	
}
