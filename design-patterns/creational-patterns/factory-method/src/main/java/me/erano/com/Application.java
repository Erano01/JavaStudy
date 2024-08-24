package me.erano.com;

import me.erano.com.example1.AdobeAcrobatClient;
import me.erano.com.example1.Client;
import me.erano.com.example1.Document;
import me.erano.com.example2.BeefBurgerRestaurant;
import me.erano.com.example2.Restaurant;
import me.erano.com.example2.VeggieBurgerRestaurant;
import me.erano.com.example2.product.Burger;

public class Application {
	
	public static void main(String[] args) {
		
//		ex1
		Client adobeAcrobatClient = new AdobeAcrobatClient();
		Document document = adobeAcrobatClient.newDocument();
		adobeAcrobatClient.openDocument(document);
		
//		ex2
		Restaurant beefResto = new BeefBurgerRestaurant();
		Burger beefBurger = beefResto.orderBurger();
		Restaurant veggieResto = new VeggieBurgerRestaurant();
		Burger veggieBurger = veggieResto.orderBurger();
		
//		ex3
		
		
		
		
		
		
		
		
		
	}

}
