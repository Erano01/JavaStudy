package me.erano.com;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import me.erano.com.example5.Client;
import me.erano.com.example5.factory.AwsResourceFactory;
import me.erano.com.example5.factory.GoogleCloudResourceFactory;
import me.erano.com.example5.factory.ResourceFactory;
import me.erano.com.example5.product.Instance;
import me.erano.com.example5.product.Instance.Capacity;

public class Application {

	
	public static void main(String[] args) {
		
//		ex1
//        WidgetFactory motifFactory = new MotifWidgetFactory();
//        Client motifApp = new Client(motifFactory);
//        motifApp.renderUI();
//        
//        WidgetFactory pmFactory = new PMWidgetFactory();
//        Client pmApp = new Client(pmFactory);
//        pmApp.renderUI();
		
//		ex2
//		MealFactory veganFactory = new VeganMealFactory();
//        Restaurant veganRestaurant = new Restaurant(veganFactory);
//        veganRestaurant.serveMeal();
//
//        MealFactory normalFactory = new NormalMealFactory();
//        Restaurant normalRestaurant = new Restaurant(normalFactory);
//        normalRestaurant.serveMeal();
		
//      ex3
//        Company msi = new MsiManufacturer();
//        GPU msiGpu = msi.createGpu();
//        Monitor msiMonitor = msi.createMonitor();
//        msiGpu.assemble();
//        msiMonitor.assemble();
        
//		ex4
//		UnitFactory industrialUnitFactory = new IndustrialAgeUnitFactory();
//		Client player1 = new Client(industrialUnitFactory);
//		player1.renderGame();
//		
//		UnitFactory medievalUnitFactory = new MedievalUnitFactory();
//		Client player2 = new Client(medievalUnitFactory);
//		player2.renderGame();
		
//		ex5
//		ResourceFactory awsResourceFactory = new AwsResourceFactory();
//		Client client1 = new Client(awsResourceFactory);
//		Instance awsInstance = client1.createServer(Capacity.LARGE, 100);
//		awsInstance.start();
//		awsInstance.stop();
//		
//		ResourceFactory googleResourceFactory = new GoogleCloudResourceFactory();
//		Client client2 = new Client(googleResourceFactory);
//		Instance googleInstance = client2.createServer(Capacity.MICRO, 1);
//		googleInstance.start();
//		googleInstance.stop();
		
//		ex6
		// javax.xml.parsers.DocumentBuilderFactory is good example of an abstract factory pattern.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		System.out.println("Using factory class: "+factory.getClass());
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			System.out.println("Got builder class: "+builder.getClass());
			Document doc = builder.newDocument();
			System.out.println("Got Document class: "+doc.getClass());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
