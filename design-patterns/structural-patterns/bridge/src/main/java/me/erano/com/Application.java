package me.erano.com;

import me.erano.com.example2.FifoCollection;
import me.erano.com.example2.Queue;
import me.erano.com.example2.SinglyLinkedList;

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
	}
}
