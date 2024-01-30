package me.erano.com;

public class Personal {
	
	protected final String name;
	
	protected String lastName;

	public Personal(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	public Personal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	

}
