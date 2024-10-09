package me.erano.com.example.product;

//Abstract Prototype
public interface Graphic extends Cloneable{

	Graphic clone() throws CloneNotSupportedException;

	
	
}
