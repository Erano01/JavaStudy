package me.erano.com.example3;

//object adapter
public class TextShape implements Shape{
	
	private TextView adaptee;

	public TextShape(TextView adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public String boundingBox() {
		return adaptee.getExtent();
	}

	//originally this method returns TextManipulator. We overriding this and changing its return type(covariant return type feature)
	@Override
	public String createManipulator() { 
		return "TextShape returns TextManipulator!";
	}

	
}
