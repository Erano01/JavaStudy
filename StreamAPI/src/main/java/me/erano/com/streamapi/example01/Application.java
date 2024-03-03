package me.erano.com.streamapi.example01;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
/** @author Erano -> Muhammed Ali Sert
 * 
 *Stream API stands for map-reduce-filter algorithm.
 *for use mapping -> @see Function interface
 *for use filtering -> @see Predicate interface
 *for use reducing -> @see Collector interface
 *
 *Stream Interfaces: 
 *	The Stream API gives your four interfaces.
 *	@see Stream interface -> 
 *		which you can use to define pipelines of operations on any kind of objects.
 *
 *	@see IntStream interface , @see LongStream interface, @see DoubleStream interface
 * 	Number Related Streams ->  
 * 		These three streams use primitive types for numbers instead of the wrapper types to avoid boxing and unboxing.
 *  	They have almost the same methods as the methods defined in Stream
 *  
 *  
 * Why Collections returns Interfaces that extend the BaseStream interface instead of returning new Collection?:
 * for example? :
 *{ @code
 * Collection<Integer> populations         = cities.map(city -> city.getPopulation());
 * Collection<Integer> filteredPopulations = populations.filter(population -> population > 100_000);
 * int sum = filteredPopulations.sum();
 *}                   
 * NO. The reason for this design choice is to ensure that the returned collection maintains a reference to the original collection,
 *  allowing changes in one to be reflected in the other. This approach avoids unnecessary memory overhead and improves performance since
 *  it doesn't involve creating a new collection.(thats why map(), filter(), reduce() methods in Stream interface)
 *  if you implementing this using by stream() before map(), filter() etc you also causing in-memory overhead.
 *  
 * Why we shouldn't assign intermediate streams to Stream variables?:
 * for example? :
 * { @code
 * Stream<City> streamOfCities         = cities.stream();
 * Stream<Integer> populations         = streamOfCities.map(city -> city.getPopulation());
 * Stream<Integer> filteredPopulations = populations.filter(population -> population > 100_000);
 * int sum = filteredPopulations.sum();
 * }
 * No this is bad. The Stream interface avoids creating intermediate structures to store mapped or filtered objects.
 * Here the map() and filter() methods are still returning new streams. So for this code to work and be efficient, 
 * no data should be stored in these streams. The streams created in this code, streamOfCities, populations and filteredPopulations must all be empty objects.
 * It leads to a very important property of streams:
 * **A stream is an object that does not store any data.**
 * This caused in-memory overhead which is assigning intermediate streams to Stream variables.
 **/

public class Application {

	public static void main(String[] args) {
		System.out.println("Printing simpleMapReduceFilterExampleWithoutStreamAPI():");
		simpleMapReduceFilterExampleWithoutStreamAPI();
		System.out.println("Printing simpleMapReduceFilterExampleWithStreamAPI():");
		simpleMapReduceFilterExampleWithStreamAPI();
		System.out.println("Printing causingInMemoryOverheadByAssigningIntermediateStreamsToStreamVariables():");
		causingInMemoryOverheadByAssigningIntermediateStreamsToStreamVariables();
		System.out.println("Printing causingInMemoryOverheadByAssigningIntermediateCollectionsToCollectionVariables():");
		causingInMemoryOverheadByAssigningIntermediateCollectionsToCollectionVariables();
	}
	public static void simpleMapReduceFilterExampleWithoutStreamAPI() {
		List<Sale> sales = List.of(
				new Sale("Rampage Monitor",LocalDate.of(2001, Month.MARCH, 10),20),
				new Sale("Razer Keyboard",LocalDate.of(2010, Month.MARCH, 20),10),
				new Sale("MSI Clutch M8 Mouse",LocalDate.of(2010, Month.DECEMBER, 10),10)
				);
		int amountSoldInMarch = 0;
		for (Sale sale: sales) {
		    if (sale.getDate().getMonth() == Month.MARCH) {
		        amountSoldInMarch += sale.getAmount();
		    }
		}
		System.out.println("Amount sold in March (without Stream API): " + amountSoldInMarch);
	}
	public static void simpleMapReduceFilterExampleWithStreamAPI() {
        List<Sale> sales = List.of(
                new Sale("Rampage Monitor", LocalDate.of(2001, Month.MARCH, 10), 20),
                new Sale("Razer Keyboard", LocalDate.of(2010, Month.MARCH, 20), 10),
                new Sale("MSI Clutch M8 Mouse", LocalDate.of(2010, Month.DECEMBER, 10), 10)
        );

        int amountSoldInMarch = sales.stream()
                .filter(sale -> sale.getDate().getMonth() == Month.MARCH)
                .mapToInt(Sale::getAmount)
                .sum();

        System.out.println("Amount sold in March (with Stream API): " + amountSoldInMarch);
	}
	public static void causingInMemoryOverheadByAssigningIntermediateStreamsToStreamVariables() {
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
	public static void causingInMemoryOverheadByAssigningIntermediateCollectionsToCollectionVariables() {
		List<City> cities = List.of(
				new City("Adana", 2000000),
				new City("Mersin",1000000),
				new City("Erzurum",10000)
				);
		Collection<Integer> populations         = cities.stream().map(City::getPopulation).collect(Collectors.toList());
		Collection<Integer> filteredPopulations = populations.stream().filter(population -> population > 100_000).collect(Collectors.toList());
		int sum                                 = filteredPopulations.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum (with StreamAPI2)= " + sum);
	}
}
