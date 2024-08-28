package me.erano.com;

import java.util.AbstractCollection;

import me.erano.com.example4.Client;
import me.erano.com.example4.creator.Figure;
import me.erano.com.example4.creator.LineFigure;
import me.erano.com.example4.creator.TextFigure;
import me.erano.com.example4.product.Manipulator;

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
//		MessageCreator jsonCreator = new JSONMessageCreator();
//		Message jsonMsg = jsonCreator.getMessage();
//		System.out.println(jsonMsg.getContent());
//		
//		MessageCreator textCreator = new TextMessageCreator();
//		Message textMsg = textCreator.getMessage();
//		System.out.println(textMsg.getContent());
		
//		ex4
		Figure lineFigure = new LineFigure();
        Manipulator lineManipulator = lineFigure.createManipulator();

        Figure textFigure = new TextFigure();
        Manipulator textManipulator = textFigure.createManipulator();

        Client client = new Client();
        client.setManipulator(lineManipulator);
        System.out.println("Performing manipulation with LineManipulator:");
        client.performManipulation();

        client.setManipulator(textManipulator);
        System.out.println("\nPerforming manipulation with TextManipulator:");
        client.performManipulation();
		
//		ex5
		
		
//		ex6
		
		
		
		
		
		
		
		
	}

}
