package me.erano.com;

import me.erano.com.example.abstraction.IconWindow;
import me.erano.com.example.abstraction.TransientWindow;
import me.erano.com.example.abstraction.Window;
import me.erano.com.example.implementor.PMWindowImp;
import me.erano.com.example.implementor.WindowImp;
import me.erano.com.example.implementor.XWindowImp;
import me.erano.com.example2.FifoCollection;
import me.erano.com.example2.Queue;
import me.erano.com.example2.SinglyLinkedList;
import me.erano.com.example3.abstraction.AmericanRestaurant;
import me.erano.com.example3.abstraction.ItalianRestaurant;
import me.erano.com.example3.abstraction.Restaurant;
import me.erano.com.example3.implementator.PepperoniPizza;
import me.erano.com.example3.implementator.VeggiePizza;

public class Application {

	public static void main(String[] args) {
		
//		ex1
		WindowImp xWindowImp = new XWindowImp();
		Window iconWindow = new IconWindow(xWindowImp);
		iconWindow.drawRect();
		iconWindow.drawText();
		
		WindowImp pmWindowImp = new PMWindowImp();
		Window transientWindow = new TransientWindow(pmWindowImp);
		transientWindow.drawRect();
		transientWindow.drawText();
		
//		ex2
		FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
		collection.offer(10);
		collection.offer(40);
		collection.offer(99);
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		
//		ex3
		Restaurant americanRestaurant = new AmericanRestaurant(new PepperoniPizza());
        americanRestaurant.deliver();

        System.out.println("==========================================");

        Restaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();
        
//      ex4
//      	an example of bridge pattern often given is the JDBC API. More specifically the java.sql.DriverManager(abstraction class) class
//      	with the java.sql.Driver(implementor interface) interface form a bridge pattern.
//			com.mysql.jdbc.Driver and oracle.jdbc.driver.Driver is concrete implementors.

//      ex5
//      	an example of bridge pattern often given is the Collections.newSetFromMap() method.
//      	This method returns a Set which is backed by given map object.
//        	see. 
        
        
	}
}
