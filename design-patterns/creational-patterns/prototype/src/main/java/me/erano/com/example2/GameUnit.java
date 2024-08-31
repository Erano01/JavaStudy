package me.erano.com.example2;

//Abstract Prototype
public abstract class GameUnit implements Cloneable {
	
	//this is immutable field -> Point3D object 
	//that means once you create an object of Point3D, you cannot modify it
	//which means we can get away with shallow copy.
	private Point3D position;
	
	public GameUnit() {
		position = Point3D.ZERO;
	}
	
	//We can use covariant return type feature by writing clone() method.
	@Override
	public GameUnit clone() throws CloneNotSupportedException {
		//clone method returns Object class instance so we have to cast.
		GameUnit unit = (GameUnit)super.clone();
		unit.initialize();
		return unit;
	}

	// reseting the state(field) of current object
	protected void initialize() {
		this.position = Point3D.ZERO;
		reset();
	}
	
	protected abstract void reset();
	
	public GameUnit(float x, float y, float z) {
		position = new Point3D(x, y, z);
	}

	public void move(Point3D direction, float distance) {
		Point3D finalMove = direction.normalize();
		finalMove = finalMove.multiply(distance);
		position = position.add(finalMove);
	}
	
	public Point3D getPosition() {
		return position;
	}
}
