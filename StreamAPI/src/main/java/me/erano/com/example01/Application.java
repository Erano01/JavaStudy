package me.erano.com.example01;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
/**
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
 *	Pupose: Initiates the operations in a Stream chain and produces a result.
 *	Effect on Stream: Returns the result of the operation and closes the Stream.
 *	Concurrency: May not support parallel operations, typically processes all elements sequentially.
 *terminal operation examples (include overload methods) -> 
 *{@link java.util.stream.Stream#forEach(java.util.function.Consumer)}, 
 *{@link java.util.stream.Stream#collect(Collector)}, 
 *{@link java.util.stream.Stream#reduce(java.util.function.BinaryOperator)}, 
 *{@link java.util.stream.Stream#count()} 
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