package me.erano.com.example5;

import java.time.LocalDate;

import me.erano.com.example5.product.UserDTO;

//Builder interface
public interface UserDTOBuilder {

	UserDTOBuilder withFirstName(String fname);
	
	UserDTOBuilder withLastName(String lname);
	
	UserDTOBuilder withBirthday(LocalDate date);
	
	UserDTOBuilder withAddress(Address address);
	
	UserDTO build();
	
	UserDTO getUserDTO();
}
