package me.erano.com.example5;

import java.time.LocalDate;

import me.erano.com.example5.product.UserDTO;

//Director class
public class Client {
	
	public UserDTO buildUser(UserDTOBuilder builder,User user) {
		return builder
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress())
				.build();
	}
}
