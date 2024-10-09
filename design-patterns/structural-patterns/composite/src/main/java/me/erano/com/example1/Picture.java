package me.erano.com.example1;

import java.util.ArrayList;
import java.util.List;

//Composite
public class Picture implements Graphic{

	private List<Graphic> graphics = new ArrayList<>();

	@Override
	public void draw() {
		System.out.println("Drawing a Picture");
		graphics.forEach(Graphic::draw);
		
	}

	@Override
	public boolean add(Graphic graphic) {
		return graphics.add(graphic);
	}

	@Override
	public boolean remove(Graphic graphic) {
		return graphics.remove(graphic);
	}

	@Override
	public Graphic getChild(int i) {
		return graphics.get(i);
	}
	
	
	
}
