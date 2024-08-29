package me.erano.com.example5.product;

public interface Instance {
	enum Capacity{MICRO,SMALL,LARGE}
	
	void start();
	void stop();
	void attachStorage(Storage storage);
}
