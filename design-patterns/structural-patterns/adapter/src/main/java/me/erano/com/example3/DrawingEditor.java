package me.erano.com.example3;


//client
public class DrawingEditor {

	public String draw(Shape shape) {
		String shapeOperations = "";
		shapeOperations += shape.boundingBox();
		shapeOperations += "\n" + shape.createManipulator();
		return shapeOperations;
	}
}
