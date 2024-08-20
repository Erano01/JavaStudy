package me.erano.com;

import me.erano.com.example3.CarBuilder;
import me.erano.com.example3.CarSchemaBuilder;
import me.erano.com.example3.Director;

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
		Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.buildBugatti(builder);
        builder.model("Chiron");
        System.out.println(builder.build());

        CarSchemaBuilder schemaBuilder = new CarSchemaBuilder();
        director.buildLambo(schemaBuilder);
        schemaBuilder.engine("90").nbrOfDoors(3);
        System.out.println(schemaBuilder.build());
		
	}
}
