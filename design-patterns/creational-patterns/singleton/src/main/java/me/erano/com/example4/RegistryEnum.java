package me.erano.com.example4;

//this version of singleton presented by joshua bloch in the google in 2008
//it is also mentioned in the effective java book
public enum RegistryEnum {

	//having your singleton as an enum takes care of a couple of problems
	//first of all you cannot extend from any enum so that means you dont have to worry about inheritance
	//second, you cannot create objects of enum in your class
	INSTANCE;
	
	int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
