package me.erano.com.example1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Non-Terminal Expression
// repetition ::= expression '*'
public class RepetitionExpression extends RegularExpression {
    private RegularExpression expression;
    private int repetition;

    public RepetitionExpression(RegularExpression expression, int repetition){
        super(expression.getContext());
        this.expression = expression;
        this.repetition = repetition;
    }
    private RepetitionExpression(String context){
        super(context);
    }

    @Override
    public boolean interpret(RegularExpression argExpression) {
        String target = argExpression.getContext();
        String pattern = expression.getContext();
        int index = 0;
        int count = 0;
        while ((index = target.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
            
        }
        // Return true if the pattern is repeated exactly 'repetition' times
        return count == this.repetition;
    }


}
