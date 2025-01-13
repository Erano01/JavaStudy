package me.erano.com;

import me.erano.com.example1.*;
import me.erano.com.example2.ExpressionBuilder;
import me.erano.com.example2.PermissionExpression;
import me.erano.com.example2.Report;
import me.erano.com.example2.User;

public class Application {

    public static void main(String[] args) {

        // Grammar: raining & (dogs | cats) *1
        // Terminal expressions
        RegularExpression raining = new LiteralExpression("raining");
        RegularExpression dogs = new LiteralExpression("dogs");
        RegularExpression cats = new LiteralExpression("cats");
        RegularExpression sentence = new LiteralExpression("It is raining cats and dogs and big dogs");

        // Non-terminal expressions
        RegularExpression alternation = new AlternationExpression(dogs, cats);
        System.out.println(alternation.interpret(sentence));

        RegularExpression repetition = new RepetitionExpression(dogs, 1);
        System.out.println(repetition.interpret(sentence));

        RegularExpression sequence = new SequenceExpression(raining, cats);
        System.out.println(sequence.interpret(sentence));

        // example 2
        /*
        Report report1  = new Report("Cashflow repot", "FINANCE_ADMIN OR ADMIN");
        ExpressionBuilder builder = new ExpressionBuilder();

        PermissionExpression exp = builder.build(report1);
        System.out.println(exp);

        User user1 = new User("Dave", "USER");

        System.out.println("User access report:"+ exp.interpret(user1));

         */

        // Regex API (java.util.regex) ->
        // The Pattern and Matcher classes interpret regular expressions and evaluate them against input strings.

        // Scripting API (javax.script)
        // The ScriptEngine provides an interpreter for scripting languages like JavaScript, allowing evaluation of dynamic expressions.

        // Formatting and Parsing (java.text and java.util.Scanner) ->
        // Classes like SimpleDateFormat and Scanner parse and format inputs, effectively interpreting structured data.

        // Java Compiler API (javax.tools) ->
        // This API interprets and compiles Java source code dynamically at runtime.

        // Stream API and Lambda Expressions ->
        // Functional constructs in Java, such as lambdas and streams, interpret and evaluate operations on collections.

        // Spring Expression Language (SpEL) ->
    }


}
