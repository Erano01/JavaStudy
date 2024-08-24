package me.erano.com.example2;

import me.erano.com.example2.product.Burger;

//Abstract Creator -> This can be also interface
public abstract class Restaurant {

	public Burger orderBurger() {
		Burger burger = createBurger();
		burger.prepare();
		return burger;
	}
	
	//factory method
	public abstract Burger createBurger();
}
