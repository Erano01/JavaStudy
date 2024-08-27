package me.erano.com;

import java.util.AbstractCollection;

import me.erano.com.example3.JSONMessageCreator;
import me.erano.com.example3.MessageCreator;
import me.erano.com.example3.TextMessageCreator;
import me.erano.com.example3.product.Message;

public class Application {
	
	//note java.util.AbstractCollection class is example of real life example inside of java
	// iterator() is factory method. 
	private AbstractCollection collection;
	
	public static void main(String[] args) {
		
//		ex1
//		Client adobeAcrobatClient = new AdobeAcrobatClient();
//		Document document = adobeAcrobatClient.newDocument();
//		adobeAcrobatClient.openDocument(document);
		
//		ex2
//		Restaurant beefResto = new BeefBurgerRestaurant();
//		Burger beefBurger = beefResto.orderBurger();
//		Restaurant veggieResto = new VeggieBurgerRestaurant();
//		Burger veggieBurger = veggieResto.orderBurger();
		
//		ex3
		MessageCreator jsonCreator = new JSONMessageCreator();
		Message jsonMsg = jsonCreator.getMessage();
		System.out.println(jsonMsg.getContent());
		
		MessageCreator textCreator = new TextMessageCreator();
		Message textMsg = textCreator.getMessage();
		System.out.println(textMsg.getContent());
		
//		ex4
		
		
//		ex5
		
		
//		ex6
		
		
		
		
		
		
		
		
	}

}
