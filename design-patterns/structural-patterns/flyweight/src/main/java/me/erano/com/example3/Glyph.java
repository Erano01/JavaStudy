package me.erano.com.example3;

//flyweight interface -> declares an interface through which flyweights can receive and act on extrinsic state.
public interface Glyph {
	
	void draw(String extrinsicState);  // extrinsic state is passed in
	
}
