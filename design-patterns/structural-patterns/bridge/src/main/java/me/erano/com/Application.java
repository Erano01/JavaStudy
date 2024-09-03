package me.erano.com;

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
		
	}
}
