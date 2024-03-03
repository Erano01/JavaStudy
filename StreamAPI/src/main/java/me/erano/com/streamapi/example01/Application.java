package me.erano.com.streamapi.example01;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
/**
 * 
 *Stream API stands for map-reduce-filter algorithm.
 *for use mapping -> @see Function interface
 *for use filtering -> @see Predicate interface
 *for use reducing -> @see Collector interface
 *
 *intermediate operation: 
 *	Purpose: It is used to transform or filter the data stream on Stream. 
 *	Effect on Stream : It does not change the stream, it @returns a new Stream. It works sequentially with other intermediate operations in the chain.
 *	Concurrency: Supports parallel operations, processes operations individually.
 *intermediate operation examples (include overload methods) -> 
 *{@link java.util.stream.Stream#map(Function)} , 
 *{@link java.util.stream.Stream#filter(Predicate)}, 
 *{@link java.util.stream.Stream#distinct()}, 
 *{@link java.util.stream.Stream#sorted()} 
 *
 *terminal operation:
 *	Purpose: Initiates the operations in a Stream chain and produces a result.
 *	Effect on Stream: Returns the result of the operation and closes the Stream.
 *	Concurrency: May not support parallel operations, typically processes all elements sequentially.
 *terminal operation examples (include overload methods) -> 
 *{@link java.util.stream.Stream#forEach(java.util.function.Consumer)}, 
 *{@link java.util.stream.Stream#collect(Collector)}, 
 *{@link java.util.stream.Stream#reduce(java.util.function.BinaryOperator)}, 
 *{@link java.util.stream.Stream#count()} 
 *
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
 *  
 *  
 * Why we shouldn't create Stream variables to store streams that we process?:
 * { @code
 * Stream<City> streamOfCities         = cities.stream();
 * Stream<Integer> populations         = streamOfCities.map(city -> city.getPopulation());
 * Stream<Integer> filteredPopulations = populations.filter(population -> population > 100_000);
 * int sum = filteredPopulations.sum();
 * }
 * The Stream interface avoids creating intermediate structures to store mapped or filtered objects.
 * Here the map() and filter() methods are still returning new streams. So for this code to work and be efficient, no data should be stored in these streams. The streams created in this code, streamOfCities, populations and filteredPopulations must all be empty objects.
 * It leads to a very important property of streams:
 * A stream is an object that does not store any data.
 **/

public class Application {

	public static void main(String[] args) {
		withoutStreamAPI();
		withStreamAPI();
	}
	public static void withStreamAPI() {
        List<Sale> sales = List.of(
                new Sale("Rampage Monitor", LocalDate.of(2001, Month.MARCH, 10), 20),
                new Sale("Razer Keyboard", LocalDate.of(2010, Month.MARCH, 20), 10),
                new Sale("MSI Clutch M8 Mouse", LocalDate.of(2010, Month.DECEMBER, 10), 10)
        );

        int amountSoldInMarch = sales.stream()
                .filter(sale -> sale.getDate().getMonth() == Month.MARCH)
                .mapToInt(Sale::getAmount) //(sale) -> sale.getAmount()
                .sum();

        System.out.println("Amount sold in March (with Stream API): " + amountSoldInMarch);
	}
	
	public static void withoutStreamAPI() {
		List<Sale> sales = List.of(
				new Sale("Rampage Monitor",LocalDate.of(2001, Month.MARCH, 10),20),
				//new Sale("MSI Clutch M8 Mouse",LocalDate.now(),10),
				new Sale("Razer Keyboard",LocalDate.of(2010, Month.MARCH, 20),10),
				new Sale("MSI Clutch M8 Mouse",LocalDate.of(2010, Month.DECEMBER, 10),10)
				);
		//mapping = List<Sale> sales -> int amountSoldInMarch
		int amountSoldInMarch = 0;
		for (Sale sale: sales) {
			//filtering
		    if (sale.getDate().getMonth() == Month.MARCH) {
		    	//sum
		        amountSoldInMarch += sale.getAmount();
		    }
		}
		System.out.println("Amount sold in March (without Stream API): " + amountSoldInMarch);
	}
}
