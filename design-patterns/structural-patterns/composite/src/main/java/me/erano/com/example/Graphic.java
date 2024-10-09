package me.erano.com.example;

//Component
public interface Graphic {

	void draw();
	boolean add(Graphic graphic);
	boolean remove(Graphic graphic);
	Graphic getChild(int i);
}
