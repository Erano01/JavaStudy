package me.erano.com;

//import me.erano.com.example1.*;
import me.erano.com.example2.*;

public class Application {

	public static void main(String[] args) {
		
//		ex1
//		Director director = new Director();
//		EndpointBuilder endpointBuilder = new EndpointBuilder();
//		director.buildFFPLeaderboards(endpointBuilder);
//		Endpoint endpoint = endpointBuilder.build();
//		System.out.println(endpoint.getUrl());
		
//		ex2
		Endpoint endpoint = new Endpoint
				.EndpointBuilder("https://freefoodparty.com")
				.setPath("/leaderboards")
				.addQueryParam("name", "JR_AIZAMK")
				.build();
		System.out.println(endpoint.getUrl());
	}
}
