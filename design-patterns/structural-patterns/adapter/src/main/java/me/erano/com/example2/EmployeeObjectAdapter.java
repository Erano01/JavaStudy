package me.erano.com.example2;

import me.erano.com.example1.Customer;
import me.erano.com.example1.Employee;

//adapter -> class adapter/two way adapter
public class EmployeeObjectAdapter implements Customer{

	private Employee adaptee;
	
	public EmployeeObjectAdapter(Employee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public String getName() {
		return adaptee.getFullName();
	}

	@Override
	public String getDesignation() {
		return adaptee.getJobTitle();
	}

	@Override
	public String getAddress() {
		return adaptee.getOfficeLocation();
	}

	
	
	
}
