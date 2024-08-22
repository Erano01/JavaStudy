package me.erano.com.example6;


import me.erano.com.example6.User;
import me.erano.com.example6.UserDTO.UserDTOBuilder;

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
