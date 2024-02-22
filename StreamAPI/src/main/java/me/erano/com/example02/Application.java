package me.erano.com.example02;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

	public static void main(String[] args) {
		withoutStreamAPI();
		withStreamAPI();
		withStreamAPI2();
		withStreamAPI3();
	}
	public static void withStreamAPI3() {
		List<City> cities = List.of(
				new City("Adana", 2000000),
				new City("Mersin",1000000),
				new City("Erzurum",10000)
				);
		
		Stream<City> streamOfCities         = cities.stream();
		Stream<Integer> populations         = streamOfCities.map(city -> city.getPopulation());
		Stream<Integer> filteredPopulations = populations.filter(population -> population > 100_000);
		int sum = filteredPopulations.mapToInt(Integer::intValue).sum(); // in fact this code does not compile; we'll fix it later
		System.out.println("Sum (with StreamAPI3)= " + sum);
	}
	public static void withStreamAPI2() {
		List<City> cities = List.of(
				new City("Adana", 2000000),
				new City("Mersin",1000000),
				new City("Erzurum",10000)
				);
		//aşağıdaki koleksiyonlar programda ek yüke neden olur.(çünkü istenilen senaryoda bunlara gerek yoktur.)
		Collection<Integer> populations         = cities.stream().map(City::getPopulation).collect(Collectors.toList());
		Collection<Integer> filteredPopulations = populations.stream().filter(population -> population > 100_000).collect(Collectors.toList());
		int sum                                 = filteredPopulations.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum (with StreamAPI2)= " + sum);
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
