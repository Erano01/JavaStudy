package me.erano.com.streamapi.example02;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author Erano -> Muhammed Ali Sert
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
 * Why we need to use terminal operations on streams? :
 * Terminal operations in Java Streams are necessary to trigger the processing of elements within the stream pipeline.
 * By themselves, intermediate operations do not execute any processing;
 * they only define the stream transformations that will be applied when a terminal operation is invoked.
 * 
 * Reasons:
 * Eager Evaluation -> Streams in Java use lazy evaluation, meaning that intermediate operations are 
 * 	only executed when a terminal operation is invoked. This helps optimize performance by deferring execution until necessary.
 * Data Processing -> Terminal operations consume elements from a Stream and produce a result or a side effect. 
 * 	They allow you to gather, process, and act upon the elements of a Stream to achieve the desired outcome.
 * Immutable Streams -> Streams in Java are immutable; once created, they cannot be modified. 
 * 	Terminal operations provide a way to obtain a result or perform actions without altering the original Stream.
 * End of the Pipeline -> Terminal operations signify the end of a stream pipeline and are necessary to terminate the stream processing.
 *  They return a non stream result, such as a single value, a collection, or a side-effect operation.
 * Short-Circuiting -> Some terminal operations, such as findAny(), findFirst(), and anyMatch(), 
 * 	can optimize processing by stopping early once a condition is met.This is particularly useful when working with infinite streams.
 * 
 * 
 **/
public class Application {

	public static void main(String[] args) {
		System.out.println("Printing : mappingStreamsByUsingFunctionWithoutTerminalOperation()");
		mappingStreamsByUsingFunctionWithoutTerminalOperation();
		
		
	}
	
	public static void mappingStreamsByUsingFunctionWithoutTerminalOperation() {
		List<String> strings = List.of("one", "two", "three", "four");
		Function<String, Integer> toLength = String::length;
		Stream<Integer> ints = strings.stream()
		                              .map(toLength);
		System.out.println(ints);
	}
	
}
