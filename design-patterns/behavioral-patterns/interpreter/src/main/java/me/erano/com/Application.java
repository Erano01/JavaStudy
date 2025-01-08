package me.erano.com;

import me.erano.com.example2.ExpressionBuilder;
import me.erano.com.example2.PermissionExpression;
import me.erano.com.example2.Report;
import me.erano.com.example2.User;

public class Application {

    public static void main(String[] args) {
        // example 1

        // example 2
        Report report1  = new Report("Cashflow repot", "FINANCE_ADMIN OR ADMIN");
        ExpressionBuilder builder = new ExpressionBuilder();

        PermissionExpression exp = builder.build(report1);
        System.out.println(exp);

        User user1 = new User("Dave", "USER");

        System.out.println("User access report:"+ exp.interpret(user1));

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
