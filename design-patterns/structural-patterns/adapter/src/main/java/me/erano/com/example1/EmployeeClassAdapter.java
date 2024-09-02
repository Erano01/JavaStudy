package me.erano.com.example1;

//adapter -> class adapter/two way adapter
public class EmployeeClassAdapter extends Employee implements Customer{

	@Override
	public String getName() {
		return this.getFullName();
	}

	@Override
	public String getDesignation() {
		return this.getJobTitle();
	}

	@Override
	public String getAddress() {
		return this.getOfficeLocation();
	}
	
	
}