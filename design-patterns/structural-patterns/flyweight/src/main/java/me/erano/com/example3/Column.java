package me.erano.com.example3;

import java.util.ArrayList;
import java.util.List;

//UnsharedConcreteFlyweight: Column
//Not all Flyweight subclasses need to be shared. 
//The Flyweight interface enables sharing; it doesn't enforce it. 
//It's common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight objects as children at some level in the 
//flyweight object structure (as the Row and Column classes have).
public class Column implements Glyph {
	private final List<Glyph> children = new ArrayList<>();

	public void add(Glyph glyph) {
		children.add(glyph);
	}

	@Override
	public void draw(String font) {
		System.out.println("Drawing Column with font: " + font);
		for (Glyph child : children) {
			child.draw(font);
		}
	}
}
