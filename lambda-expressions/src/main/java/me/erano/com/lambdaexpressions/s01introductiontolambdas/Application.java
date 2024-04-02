package me.erano.com.lambdaexpressions.s01introductiontolambdas;
import java.util.function.*;

/*
 * @author Erano -> Muhammed Ali Sert 
 * 
 * What is Lambda Expressions ->
 * 		Lambda Expressions were added in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value.
 * 		Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
 * 
 * Before Lambda Expressions ->
 * 		If you remember the days before Java SE 8 was released, then you probably remember the anonymous classes concept.
 * 		And maybe you have heard that lambda expressions are another, simpler way of writing instances of anonymous classes,
 * 		in some precise cases.
 * 
 * How to implement Lambda Expressions ->
 * 		1-)identifying the type of the lambda expression you want to write
 * 		2-)finding the right method to implement
 * 		3-)implementing this method.
 * 
 * 1-)Identifying the Type of a Lambda Expression ->
 * 		Everything has a type in the Java language, and this type is known at compile time. So it is always possible to find 
 * 		the type of a lambda expression. It may be the type of a variable, of a field, of a method parameter, or the returned type of a method.
 * 		There is a restriction on the type of a lambda expression: 
 * 		it has to be a functional interface. So an anonymous class that does not implement a functional interface cannot be written 
 * 		as a lambda expression.
 * 		The complete definition of what functional interfaces are is a little complex. 
 * 		All you need to know at this point is that a functional interface is an interface that has only one abstract method.
 * 		
 * 		@FunctionalInterface ->
 * 			examples : Runnable, Consumer, Predicate 
 * 
 * 2-)Finding the right method to implement ->
 * 		A lambda expression is an implementation of the only abstract method in this functional interface
 * 
 * 3-)Implementing this method ->
 * 		java.util.function.Predicate -> test()
 * 		java.util.function.Consumer -> accept()
 * 		java.util.function.Runnable -> run()
 * 		java.util.function.Comparator -> compare()
 * 
 * */
public class Application {

	public static void main(String[] args) {
		
	}
	
	
}
