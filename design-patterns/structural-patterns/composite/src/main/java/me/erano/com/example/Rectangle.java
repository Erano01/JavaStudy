package me.erano.com.example;

//leaf
public class Rectangle implements Graphic{

	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle");
	}

	@Override
	public boolean add(Graphic graphic) {
		throw new UnsupportedOperationException("\"Leaf node doesn't support add operation\"");
	}

	@Override
	public boolean remove(Graphic graphic) {
		throw new UnsupportedOperationException("\"Leaf node doesn't support add operation\"");
	}

	@Override
	public Graphic getChild(int i) {
		throw new UnsupportedOperationException("\"Leaf node doesn't support add operation\"");
	}
}
