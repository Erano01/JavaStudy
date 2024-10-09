package me.erano.com.example1;

//Client
public class BusinessCardDesigner {

	public String designCardCustomer(Customer customer) {
		String card = "";
		card += customer.getName();
		card += "\n" + customer.getDesignation();
		card += "\n" + customer.getAddress();
		return card;
	}
}
