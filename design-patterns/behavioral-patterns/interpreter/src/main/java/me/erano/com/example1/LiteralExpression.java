package me.erano.com.example1;

import javax.print.attribute.standard.RequestingUserName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Terminal Expression
// literal ::- 'a' | 'b' | 'c' | ... { 'a' | 'b' | 'c' | ... }*
public class LiteralExpression extends RegularExpression {

    // { 'a' | 'b' | 'c' | ... }*
    public LiteralExpression(String literal) {
        super(literal);
    }
    // 'a' | 'b' | 'c' | ...
    public LiteralExpression(char character) {
        super(String.valueOf(character));
    }
    //iki context'in kaç adet ortak harfi var
    @Override
    public boolean interpret(RegularExpression expression) {
        System.out.println("The LiteralExpression class has the following context: " + context);
        System.out.println("Interpreting the following input: " + expression.context);

        if(!context.contains(expression.context)){
            System.out.println("The input does not match the context. Number of matches found: " + totalMatches(expression.context));
            return false;
        }
        System.out.println("The context fully matches the input.");
        return true;
    }
    private int totalMatches(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
