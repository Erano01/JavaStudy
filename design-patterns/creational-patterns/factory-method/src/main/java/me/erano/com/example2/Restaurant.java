package me.erano.com.example2;

import me.erano.com.example2.product.Burger;

//Abstract Creator
public abstract class Restaurant {

	public Burger orderBurger() {
		Burger burger = createBurger();
		burger.prepare();
		return burger;
	}
	
	//factory method -> making it protected is better implementation
	protected abstract Burger createBurger();
}
