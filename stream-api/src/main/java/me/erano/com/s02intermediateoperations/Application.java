package me.erano.com.s02intermediateoperations;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Erano -> Muhammed Ali Sert 
 *
 *Functional Interfaces that Stream API uses:
 * mapping(map(), mapMulti, )-> { @see Function, IntFunction, ToDoubleFunction, ToIntFunction, ToLongFunction, @see Consumer, BiConsumer } interfaces
 * filtering -> { @see Predicate, BiPredicate } interfaces
 * reducing -> { @see Collector, BinaryOperator } interfaces
 *
 * Mapping a Stream to Another Stream ->
 * 		Mapping a stream consists of transforming its elements using a function. This transformation may change 
 * 		the types of the elements processed by that stream, but you can also transform them without changing their type.
 * 		You can map a stream to another stream with the map(), flatMap(), mapMulti methods, which takes this Function as an argument. 
 * 		Mapping a stream means that all the elements processed by that stream will be transformed using that function.
 * 
 * Filtering a Stream ->
 * 	Filtering is about discarding some elements processed by a stream with a predicate.
 * 	This method is available on streams of objects and stream of primitive types.
 * 
 * Using Flatmap and MapMulti to Validate Elements Transformation ->
 * 	1->Flatmapping a Stream: 
 * 		In Java's Stream API, flatMap method is used to transform each element in a stream into another stream and 
 * 		then flatten these streams into a single stream. It allows you to perform a transformation operation on each input
 * 		element and merge the resulting substreams into a single stream.
 * 		flatMap method is typically used when dealing with nested or nested collections, simplifying the data structure and
 *  	making operations more functional.
 * 		In short, flatMap method flattens nested structures of data and gathers them into a single stream, making it easier to work with.
 * 		flatMap() creating stream for each element.
 * 
 * 	2->MultiMapping a Stream:
 * 		When you create many streams of zero or one object. This method is called mapMulti() and takes a BiConsumer as an argument.
 * 		This BiConsumer consumes two arguments:
 * 			1-> The element of the stream that needs to be mapped
 * 			2-> A @see Consumer that this @see BiConsumer needs to call with the result of the mapping
 * 
 * 
 * 
 * Removing Duplicates and Sorting a Stream ->
 * 		The Stream API has two methods, distinct() and sorted(), that will simply detect and remove duplicates and sort 
 * 		the elements of your stream. The distinct() method uses the hashCode() and equals() methods to spot the duplicates. 
 * 		The sorted() method has an overload that takes a comparator, which will be used to compare and sort the elements of your stream.
 * 		If you do not provide a comparator, then the Stream API assumes that the elements of your stream are comparable. If they are not,
 * 		then a ClassCastException is raised. 
 * 
 * 		You may remember from the previous part of this tutorial that a stream is supposed to be an
 *  	empty object that does not store any data. There are several exceptions to this rule, and these two methods belong to them.
 *  
 *  	Indeed, to spot duplicates, the distinct() method needs to store the elements of your stream. When it processes an element,
 *  	it first checks if that element has already been seen or not.
 *  
 *  	The same goes for the sorted() method. This method needs to store all of your elements and then to sort them in an internal
 *  	buffer before sending them to the next step of your processing pipeline.
 *  
 *  	The distinct() method can be used on unbound (infinite) streams, the sorted() method cannot.
 * 
 * 
 * 
 * Limiting and Skipping the Elements of a Stream ->
 *  	skip(2).limit(5) -> 3,4,5,6,7
 *  	skip(2).limit(8) -> 3,4,5,6,7,8,9,10
 *  also u can use takeWhile(), dropWhile()
 * 
 * Concatenating Streams ->
 * 		The Stream API offers several patterns to concatenate several streams into one. The most obvious way is to use a factory method 
 * 		defined in the Stream interface: concat().
 * 		This method takes two streams and produces a stream with the elements produced by the first stream, followed by the elements of the second stream.
 * 		You may be wondering why this method does not take a vararg to allow for the concatenation of any number of streams.
 * 		The reason is that using this method is OK as long as you have two streams to join. If you have more than two, then the JavaDoc API documentation
 * 		advises you to use another pattern, based on the use of flatmap.
 * 
 * 		The reason why it is better to use the flatMap() way is that concat() creates intermediates streams during the concatenation.
 * 		When you use Stream.concat(), a new stream is created to concatenate your two streams. If you need to concatenate three streams,
 * 		you will end up creating a first stream to handle the first concatenation, and a second one for the second concatenation. 
 * 		So each concatenation requires a stream that will be thrown away very quickly.
 * 
 * 		With the flatmap pattern, you just create a single stream to hold all your streams and do the flatmap. The overhead is much lower.
 * 		You may be wondering why these two patterns have been added. It looks like concat() is not really useful. In fact there is a subtle difference
 * 		between the stream produced by the concat and the flatmap patterns.
 * 		If the size of the source of the two streams you are concatenating is known, then the size of the resulting stream is known too. 
 * 		In fact, it is simply the sum of the two concatenated streams.
 * 		Using flatmap on a stream may create an unknown number of elements to be processed in the resulting stream. 
 * 		The Stream API loses track of the number of elements that will be processed in the resulting stream.
 * 		In other words: concat produces a SIZED stream, whereas flatmap does not.
 * 
 * Debugging Streams ->
 * 		It may sometimes be convenient to examine the elements processed by a stream at run time. 
 * 		The Stream API has a method for that: the peek() method. This method is meant to be used to debug your data processing pipeline.
 * 		You should not use this method in your production code.
 *
 *intermediate operation: 
 *		Purpose: It is used to transform or filter the data stream on Stream. 
 *		Effect on Stream : It does not change the stream, it @returns a new Stream. It works sequentially with other intermediate operations in the chain.
 *		Concurrency: Supports parallel operations, processes operations individually.
 *intermediate operations -> 
 *		{@link java.util.stream.Stream#map(Function)}
 *		{@link java.util.stream.Stream#mapToDouble(java.util.function.ToDoubleFunction)}
 *		{@link java.util.stream.Stream#mapToInt(java.util.function.ToIntFunction)}
 *		{@link java.util.stream.Stream#mapToLong(java.util.function.ToLongFunction)}
 *		{@link java.util.stream.Stream#mapMulti(java.util.function.BiConsumer)}
 *		{@link java.util.stream.Stream#mapMultiToDouble(java.util.function.BiConsumer)}
 *		{@link java.util.stream.Stream#mapMultiToInt(java.util.function.BiConsumer)}
 *		{@link java.util.stream.Stream#mapMultiToLong(java.util.function.BiConsumer)}
 *		{@link java.util.stream.Stream#flatMap(Function)}
 *		{@link java.util.stream.Stream#flatMapToDouble(Function)}
 *		{@link java.util.stream.Stream#flatMapToInt(Function)}
 *		{@link java.util.stream.Stream#flatMapToLong(Function)}
 *		{@link java.util.stream.Stream#filter(Predicate)}
 *		{@link java.util.stream.Stream#parallel()}
 *		{@link java.util.stream.Stream#onClose(Runnable)}
 *		{@link java.util.stream.Stream#peek(java.util.function.Consumer)}
 *		{@link java.util.stream.Stream#sequential()}
 *		{@link java.util.stream.Stream#unordered()}
 *Stateful intermediate operations ->
 *		{@link java.util.stream.Stream#distinct()}
 *		{@link java.util.stream.Stream#sorted()}
 *		{@link java.util.stream.Stream#dropWhile(Predicate)}
 *		{@link java.util.stream.Stream#skip(long)}
 *		{@link java.util.stream.Stream#sorted(java.util.Comparator)}
 *Short-circuiting intermediate operations ->
 *		{@link java.util.stream.Stream#allMatch(Predicate)}
 *		{@link java.util.stream.Stream#anyMatch(Predicate)}
 *		{@link java.util.stream.Stream#findAny()}
 *		{@link java.util.stream.Stream#findFirst()}
 *		{@link java.util.stream.Stream#limit(long)}
 *		{@link java.util.stream.Stream#noneMatch(Predicate)}
 *		{@link java.util.stream.Stream#takeWhile(Predicate)}
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
		System.out.print("Printing : flatMappingOneToOneRelationsWithoutStream()");
		flatMappingOneToOneRelationsWithoutStream();
		System.out.print("Printing : flatMappingOneToOneRelationsWithStream()");
		flatMappingOneToOneRelationsWithStream();
		System.out.print("Printing : validateElementTransformations()");
		validateElementTransformations();
		System.out.print("Printing : validateElementTransformationsWithFlatMapper()");
		validateElementTransformationsWithFlatMapper();
		System.out.print("Printing : validateElementTransformationsWithMultiMapper()");
		validateElementTransformationsWithMultiMapper();
		
		System.out.println("----------------------");
		removingDuplicatesByStreamAPI();
        sortingElementsByStreamAPIWithoutComparator();
        sortingElementsByStreamAPIWithComparator();
        
        
        System.out.println("----------------------");
        System.out.print("Printing : limitingAndSkippingElements()");
        limitingAndSkippingElements();
        System.out.print("Printing : concatenatingStreamsPattern1()");
        concatenatingStreamsPattern1();
        System.out.print("Printing : concatenatingStreamsPattern2()");
        concatenatingStreamsPattern2();
        System.out.println("Printing : debuggingStreams()");
        debuggingStreams();
	}
	
	public static void mappingStreamsByUsingFunctionWithoutTerminalOperation() {
		List<String> strings = List.of("one", "two", "three", "four");
		Function<String, Integer> toLength = String::length;
		Stream<Integer> ints = strings.stream()
		                              .map(toLength);
		System.out.println(" -> "+ints);
	}
	public static void mappingStreamsByUsingFunctionWithTerminalOperationCollect() {
		List<String> strings = List.of("one", "two", "three", "four");
		List<Integer> lengths = strings.stream()
		                               .map(String::length)
		                               .collect(Collectors.toList());
		System.out.println(" -> lengths = " + lengths);
	}
	public static void mappingStreamsToIntSummaryStatisticsByUsingFunction(){
		List<String> strings = List.of("one", "two", "three", "four");
		IntSummaryStatistics stats = strings.stream()
		                                    .mapToInt(String::length)
		                                    .summaryStatistics();
		System.out.println(" -> stats = " + stats);
	}
	public static void filteringStreamsByUsingPredicate() {
		List<String> strings = List.of("one", "two", "three", "four");
		long count = strings.stream()
		                    .map(String::length)
		                    .filter(length -> length == 3)
		                    .count();
		System.out.println(" -> count = " + count);
	}
	public static void flatMappingOneToOneRelationsWithoutStream() {
		List<State> states = List.of(
				new State("State1",List.of(new City("Adana",1000),new City("Mersin",2000), new City("Gaziantep",3000))),
				new State("State1",List.of(new City("Ankara",10000),new City("Istanbul",20000), new City("Izmir",10000)))
				);
		int totalPopulation = 0;
		for (State state: states) {
		    for (City city: state.getCities()) {
		        totalPopulation += city.getPopulation();
		    }
		}
		System.out.println("-> Total population = " + totalPopulation);
	}
	public static void flatMappingOneToOneRelationsWithStream() {
		List<State> states = List.of(
				new State("State1",List.of(new City("Adana",1000),new City("Mersin",2000), new City("Gaziantep",3000))),
				new State("State1",List.of(new City("Ankara",10000),new City("Istanbul",20000), new City("Izmir",10000)))
				);
		int totalPopulation = 0;
		for (State state: states) {
			totalPopulation += state.getCities().stream().mapToInt(City::getPopulation).sum();
		}
		System.out.println(" -> Total population = " + totalPopulation);
	}
	public static void validateElementTransformations() {
		Predicate<String> isANumber = s -> {
		    try {
		        int i = Integer.parseInt(s);
		        return true;
		    } catch (NumberFormatException e) {
		        return false; //dont do it. catch block is not good for returning something
		    }
		};
		System.out.println(" -> "+isANumber); //need terminal operation here.
	}
	public static void validateElementTransformationsWithFlatMapper() {
		Function<String, Stream<Integer>> flatParser = s -> {
		    try {
		        return Stream.of(Integer.parseInt(s));
		    } catch (NumberFormatException e) {
		    }
		    return Stream.empty();
		};

		List<String> strings = List.of("1", " ", "2", "3 ", "", "3");
		List<Integer> ints = 
		    strings.stream()
		           .flatMap(flatParser)
		           .collect(Collectors.toList());
		System.out.println(" -> ints = " + ints);
	}
	public static void validateElementTransformationsWithMultiMapper() {
		List<String> strings = List.of("1", " ", "2", "3 ", "", "3");
		List<Integer> ints =
		        strings.stream()
		               .<Integer>mapMulti((string, consumer) -> {
		                    try {
		                        consumer.accept(Integer.parseInt(string));
		                    } catch (NumberFormatException ignored) {
		                    }
		               })
		               .collect(Collectors.toList());
		System.out.println(" -> ints = " + ints);
	}
	public static void removingDuplicatesByStreamAPI() {
        List<Integer> numbersWithDuplicates = List.of(1, 2, 3, 1, 2, 4, 5, 6, 4, 7, 8, 9, 10, 5);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                                                              .distinct()
                                                              .collect(Collectors.toList());

        System.out.println("Original List with Duplicates: " + numbersWithDuplicates);
        System.out.println("List after Removing Duplicates: " + distinctNumbers);
    }
    public static void sortingElementsByStreamAPIWithoutComparator() {
        List<Integer> numbersToSort = List.of(5, 2, 8, 1, 7, 3, 6, 4);
        List<Integer> sortedNumbers = numbersToSort.stream()
                                                   .sorted()
                                                   .collect(Collectors.toList());

        System.out.println("Original List: " + numbersToSort);
        System.out.println("List after Sorting without Comparator: " + sortedNumbers);
    }
    public static void sortingElementsByStreamAPIWithComparator() {
        List<String> wordsToSort = List.of("Java", "Stream", "API", "Example");
        Comparator<String> lengthComparator = Comparator.comparing(String::length);

        List<String> sortedWords = wordsToSort.stream()
                                             .sorted(lengthComparator)
                                             .collect(Collectors.toList());

        System.out.println("Original List: " + wordsToSort);
        System.out.println("List after Sorting with Comparator: " + sortedWords);
    }
    public static void limitingAndSkippingElements() {
    	List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    	//also u can use takeWhile(), dropWhile() instead of skipping and limiting. 
    	List<Integer> result = 
    	    ints.stream()
    	        .skip(2)
    	        .limit(5)
    	        .collect(Collectors.toList());
    	System.out.println(" -> result = " + result);
    }
    public static void concatenatingStreamsPattern1() {
    	List<Integer> list0 = List.of(1, 2, 3);
    	List<Integer> list1 = List.of(4, 5, 6);
    	// 1st pattern: concat
    	List<Integer> concat = 
    	    Stream.concat(list0.stream(), list1.stream())
    	          .collect(Collectors.toList());
    	System.out.println(" -> concat  = " + concat);
    }
    public static void concatenatingStreamsPattern2() {
    	List<Integer> list0 = List.of(1, 2, 3);
    	List<Integer> list1 = List.of(4, 5, 6);
    	List<Integer> list2 = List.of(7, 8, 9);
    	// 2nd pattern: flatMap
    	List<Integer> flatMap =
    	    Stream.of(list0.stream(), list1.stream(), list2.stream())
    	          .flatMap(Function.identity())
    	          .collect(Collectors.toList());
    	System.out.println(" -> flatMap = " + flatMap);
    }
    public static void debuggingStreams() {
    	System.out.println(" *******DEBUGGING STREAMS PROCESS STARTED *******");
    	List<String> strings = List.of("one", "two", "three", "four");
    	List<String> result =
    	        strings.stream()
    	                .peek(s -> System.out.println("Starting with = " + s+ ", "))
    	                .filter(s -> s.startsWith("t"))
    	                .peek(s -> System.out.println("Filtered = " + s +", "))
    	                .map(String::toUpperCase)
    	                .peek(s -> System.out.println("Mapped = " + s + ", "))
    	                .collect(Collectors.toList());
    	System.out.println();
    	System.out.println(" -> result = " + result);
    }
	
}
