package me.erano.com.example4.creator;

import me.erano.com.example4.product.LineManipulator;
import me.erano.com.example4.product.Manipulator;

//concrete creator.
public class LineFigure extends Figure{

	//overriding factory method
	@Override
	public Manipulator createManipulator() {
		return new LineManipulator();
	}

	

	
}
