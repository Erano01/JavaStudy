package me.erano.com.example;

//leaf
public class Text implements Graphic{

	@Override
	public void draw() {
		System.out.println("Drawing a Text");
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
