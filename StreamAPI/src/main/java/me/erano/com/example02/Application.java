package me.erano.com.example02;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		withoutStreamAPI();
		withStreamAPI();
	}
	public static void withStreamAPI() {
		List<City> cities = List.of(
				new City("Adana", 2000000),
				new City("Mersin",1000000),
				new City("Erzurum",10000)
				);
		
		int sum = cities.stream()
                .filter(city -> city.getPopulation() > 100000)
                .mapToInt(City::getPopulation)
                .sum();
		
		System.out.println("Sum (with StreamAPI)= " + sum);
	}
	public static void withoutStreamAPI() {
		List<City> cities = List.of(
				new City("Adana", 2000000),
				new City("Mersin",1000000),
				new City("Erzurum",10000)
				);

		int sum = 0;
		for (City city: cities) {
		    int population = city.getPopulation();
		    if (population > 100_000) {
		        sum += population;
		    }
		}

		System.out.println("Sum (without StreamAPI)= " + sum);
	}
}
