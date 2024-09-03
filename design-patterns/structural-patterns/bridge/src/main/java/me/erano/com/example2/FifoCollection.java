package me.erano.com.example2;

//Abstraction
//It represent a First in First Out Collection
public interface FifoCollection<T> {

	//adds elements to collection
	void offer(T element);
	
	//Removes & returns first element from collection
	T poll();
}
