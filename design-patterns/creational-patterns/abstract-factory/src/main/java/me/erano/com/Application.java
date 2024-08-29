package me.erano.com;

import me.erano.com.example1.Client;
import me.erano.com.example1.factories.MotifWidgetFactory;
import me.erano.com.example1.factories.PMWidgetFactory;
import me.erano.com.example1.factories.WidgetFactory;
import me.erano.com.example3.Company;
import me.erano.com.example3.factories.MsiManufacturer;
import me.erano.com.example3.products.GPU;
import me.erano.com.example3.products.Monitor;

public class Application {

	public static void main(String[] args) {
		
//		ex1
        WidgetFactory motifFactory = new MotifWidgetFactory();
        Client motifApp = new Client(motifFactory);
        motifApp.renderUI();
        
        WidgetFactory pmFactory = new PMWidgetFactory();
        Client pmApp = new Client(pmFactory);
        pmApp.renderUI();
		
//		ex2
//		MealFactory veganFactory = new VeganMealFactory();
//        Restaurant veganRestaurant = new Restaurant(veganFactory);
//        veganRestaurant.serveMeal();
//
//        MealFactory normalFactory = new NormalMealFactory();
//        Restaurant normalRestaurant = new Restaurant(normalFactory);
//        normalRestaurant.serveMeal();
		
//      ex3
        Company msi = new MsiManufacturer();
        GPU msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();
        msiGpu.assemble();
        msiMonitor.assemble();
		
    }
}
