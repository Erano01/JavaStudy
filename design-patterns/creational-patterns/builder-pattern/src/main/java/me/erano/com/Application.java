package me.erano.com;

import me.erano.com.example4.ASCIIConverter;
import me.erano.com.example4.RTFReader;
import me.erano.com.example4.TeXConverter;
import me.erano.com.example4.TextConverter;
import me.erano.com.example4.TextWidgetConverter;
import me.erano.com.example4.product.ASCIIText;
import me.erano.com.example4.product.TeXText;
import me.erano.com.example4.product.TextWidget;

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
		//ASCII
        TextConverter asciiConverter = new ASCIIConverter();
        RTFReader reader = new RTFReader(asciiConverter);
        reader.parseRTF("H e l l o FArial W o r l d P T h i s FTimes P");
        ASCIIText asciiText = (ASCIIText) asciiConverter.getResult();
        System.out.println("ASCII Text: ");
        System.out.println(asciiText);

        //TeXText
        TextConverter texConverter = new TeXConverter();
        RTFReader texReader = new RTFReader(texConverter);
        texReader.parseRTF("H e l l o FArial W o r l d P T h i s FTimes P");
        TeXText texText = (TeXText) texConverter.getResult();
        System.out.println("TeX Text: ");
        System.out.println(texText);

        //TexWidget
        TextConverter widgetConverter = new TextWidgetConverter();
        RTFReader widgetReader = new RTFReader(widgetConverter);
        widgetReader.parseRTF("H e l l o FArial W o r l d P T h i s FTimes P");
        TextWidget textWidget = (TextWidget) widgetConverter.getResult();
        System.out.println("Text Widget: ");
        System.out.println(textWidget);
        
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
//        Client client =  new Client();
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
//		UserDTO userDTO= client.buildUser(UserDTO.getBuilder(), user);
//		System.out.println(userDTO.getName());
//		System.out.println(userDTO.getAge());
//		System.out.println(userDTO.getAddress());
	}
}
