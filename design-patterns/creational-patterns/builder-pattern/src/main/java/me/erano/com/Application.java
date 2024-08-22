package me.erano.com;

import java.time.LocalDate;

import me.erano.com.example6.Address;
import me.erano.com.example6.User;
import me.erano.com.example6.Client;
import me.erano.com.example6.UserDTO;



public class Application {

	public static void main(String[] args) {
		
//		ex1
//		Director director = new Director();
//		EndpointBuilder endpointBuilder = new EndpointBuilder();
//		director.buildFFPLeaderboards(endpointBuilder);
//		Endpoint endpoint = endpointBuilder.build();
//		System.out.println(endpoint.getUrl());
		
//		ex2
//		Endpoint endpoint = new Endpoint
//				.EndpointBuilder("https://freefoodparty.com")
//				.setPath("/leaderboards")
//				.addQueryParam("name", "JR_AIZAMK")
//				.build();
//		System.out.println(endpoint.getUrl());
		
//		ex3
//		Director director = new Director();
//        CarBuilder builder = new CarBuilder();
//        director.buildBugatti(builder);
//        builder.model("Chiron");
//        System.out.println(builder.build());
//        CarSchemaBuilder schemaBuilder = new CarSchemaBuilder();
//        director.buildLambo(schemaBuilder);
//        schemaBuilder.engine("90").nbrOfDoors(3);
//        System.out.println(schemaBuilder.build());
        
//      ex4
        
        
//      ex5
//		Client client = new Client();
//		UserWebDTOBuilder webDTOBuilder = new UserWebDTOBuilder();
//		User user = new User();
//		user.setBirthday(LocalDate.of(2001, 1, 1));
//		user.setFirstName("Muhammed Ali");
//		user.setLastName("Sert");
//		Address address = new Address();
//		address.setHouseNumber("100");
//		address.setStreet("State street");
//		address.setCity("Example");
//		address.setState("New Jersey");
//		address.setZipcode("47998");
//		user.setAddress(address);
//		UserDTO userDTO= client.buildUser(webDTOBuilder, user);
//        System.out.println(userDTO.getName());
//        System.out.println(userDTO.getAge());
//        System.out.println(userDTO.getAddress());
        
//      ex6
        Client client =  new Client();
		User user = new User();
		user.setBirthday(LocalDate.of(2001, 1, 1));
		user.setFirstName("Muhammed Ali");
		user.setLastName("Sert");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State street");
		address.setCity("Example");
		address.setState("New Jersey");
		address.setZipcode("47998");
		user.setAddress(address);
		UserDTO userDTO= client.buildUser(UserDTO.getBuilder(), user);
		System.out.println(userDTO.getName());
		System.out.println(userDTO.getAge());
		System.out.println(userDTO.getAddress());
	}
}
