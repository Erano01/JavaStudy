package me.erano.com.example1;

//Component
public interface Graphic {

	void draw();
	boolean add(Graphic graphic);
	boolean remove(Graphic graphic);
	Graphic getChild(int i);
}
