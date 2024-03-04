package me.erano.com.streamapi.s02intermediateoperations;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Erano -> Muhammed Ali Sert 
 *
 *Functional Interfaces that Stream API uses:
 * mapping, flat-mapping -> { @see Function, IntFunction, ToDoubleFunction, ToIntFunction, ToLongFunction } interfaces
 * filtering -> { @see Predicate, BiPredicate } interfaces
 * reducing -> { @see Collector, BinaryOperator } interfaces
 * consuming-> { @see Consumer, BiConsumer } interfaces
 *
 * Mapping a Stream to Another Stream ->
 * Mapping a stream consists of transforming its elements using a function. This transformation may change 
 * the types of the elements processed by that stream, but you can also transform them without changing their type.
 * You can map a stream to another stream with the map() method, which takes this Function as an argument. 
 * Mapping a stream means that all the elements processed by that stream will be transformed using that function.
 * 
 * Filtering a Stream ->
 * Filtering is about discarding some elements processed by a stream with a predicate.
 * This method is available on streams of objects and stream of primitive types.
 * 
 * Flatmapping a Stream to Handle 1:p (One-To-One) Relations ->
 * 
 * 
 *
 *intermediate operation: 
 *	Purpose: It is used to transform or filter the data stream on Stream. 
 *	Effect on Stream : It does not change the stream, it @returns a new Stream. It works sequentially with other intermediate operations in the chain.
 *	Concurrency: Supports parallel operations, processes operations individually.
 *intermediate operations -> 
 *	{@link java.util.stream.Stream#map(Function)}
 *	{@link java.util.stream.Stream#mapToDouble(java.util.function.ToDoubleFunction)}
 *	{@link java.util.stream.Stream#mapToInt(java.util.function.ToIntFunction)}
 *	{@link java.util.stream.Stream#mapToLong(java.util.function.ToLongFunction)}
 *	{@link java.util.stream.Stream#mapMulti(java.util.function.BiConsumer)}
 *	{@link java.util.stream.Stream#mapMultiToDouble(java.util.function.BiConsumer)}
 *	{@link java.util.stream.Stream#mapMultiToInt(java.util.function.BiConsumer)}
 *	{@link java.util.stream.Stream#mapMultiToLong(java.util.function.BiConsumer)}
 *	{@link java.util.stream.Stream#flatMap(Function)}
 *	{@link java.util.stream.Stream#flatMapToDouble(Function)}
 *	{@link java.util.stream.Stream#flatMapToInt(Function)}
 *	{@link java.util.stream.Stream#flatMapToLong(Function)}
 *	{@link java.util.stream.Stream#filter(Predicate)}
 *	{@link java.util.stream.Stream#parallel()}
 *	{@link java.util.stream.Stream#onClose(Runnable)}
 *	{@link java.util.stream.Stream#peek(java.util.function.Consumer)}
 *	{@link java.util.stream.Stream#sequential()}
 *	{@link java.util.stream.Stream#unordered()}
 *Stateful intermediate operations ->
 *	{@link java.util.stream.Stream#distinct()}
 *	{@link java.util.stream.Stream#sorted()}
 *	{@link java.util.stream.Stream#dropWhile(Predicate)}
 *	{@link java.util.stream.Stream#skip(long)}
 *	{@link java.util.stream.Stream#sorted(java.util.Comparator)}
 *Short-circuiting intermediate operations ->
 *	{@link java.util.stream.Stream#allMatch(Predicate)}
 *	{@link java.util.stream.Stream#anyMatch(Predicate)}
 *	{@link java.util.stream.Stream#findAny()}
 *	{@link java.util.stream.Stream#findFirst()}
 *	{@link java.util.stream.Stream#limit(long)}
 *	{@link java.util.stream.Stream#noneMatch(Predicate)}
 *	{@link java.util.stream.Stream#takeWhile(Predicate)}
 * 
 * 
 * 
 * 
 **/
public class Application {

	public static void main(String[] args) {
		System.out.print("Printing : mappingStreamsByUsingFunctionWithoutTerminalOperation(): ");
		mappingStreamsByUsingFunctionWithoutTerminalOperation();
		System.out.print("Printing : mappingStreamsByUsingFunctionWithTerminalOperationCollect(): ");
		mappingStreamsByUsingFunctionWithTerminalOperationCollect();
		System.out.print("Printing : mappingStreamsToIntSummaryStatisticsByUsingFunction(): ");
		mappingStreamsToIntSummaryStatisticsByUsingFunction();
		System.out.print("Printing : filteringStreamsByUsingPredicate();: ");
		filteringStreamsByUsingPredicate();
	}
	
	public static void mappingStreamsByUsingFunctionWithoutTerminalOperation() {
		List<String> strings = List.of("one", "two", "three", "four");
		Function<String, Integer> toLength = String::length;
		Stream<Integer> ints = strings.stream()
		                              .map(toLength);
		System.out.println(ints);
	}
	public static void mappingStreamsByUsingFunctionWithTerminalOperationCollect() {
		List<String> strings = List.of("one", "two", "three", "four");
		List<Integer> lengths = strings.stream()
		                               .map(String::length)
		                               .collect(Collectors.toList());
		System.out.println("lengths = " + lengths);
	}
	public static void mappingStreamsToIntSummaryStatisticsByUsingFunction(){
		List<String> strings = List.of("one", "two", "three", "four");
		IntSummaryStatistics stats = strings.stream()
		                                    .mapToInt(String::length)
		                                    .summaryStatistics();
		System.out.println("stats = " + stats);
	}
	public static void filteringStreamsByUsingPredicate() {
		List<String> strings = List.of("one", "two", "three", "four");
		long count = strings.stream()
		                    .map(String::length)
		                    .filter(length -> length == 3)
		                    .count();
		System.out.println("count = " + count);
	}
	
}
