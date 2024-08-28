package me.erano.com.example4.creator;

import me.erano.com.example4.product.Manipulator;
import me.erano.com.example4.product.TextManipulator;

//abstract creator.
public class TextFigure extends Figure{

	//overriding factory method.
	@Override
	public Manipulator createManipulator() {
		return new TextManipulator();
	}

	
}
