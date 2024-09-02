package me.erano.com.example3;

//this class is optional
public class Line implements Shape{

	@Override
	public String boundingBox() {
		return "Line bounding box";
	}

	@Override
	public String createManipulator() {
		return "Line created Manipulator";
	}

	
}
