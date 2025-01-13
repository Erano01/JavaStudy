package me.erano.com.example1;

//Non-Terminal Expression
// alternation ::- expression '|' expression
public class AlternationExpression extends RegularExpression {
    private RegularExpression expression1;
    private RegularExpression expression2;

    public AlternationExpression(RegularExpression expression1, RegularExpression expression2) {
        super(new String(expression1.getContext() + " | " +expression2.getContext()));
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    private AlternationExpression(String context){
        super(context);
    }

    @Override
    public boolean interpret(RegularExpression expression) {
        if(expression.getContext().contains(expression1.getContext()) |
            expression.getContext().contains(expression2.getContext())){
            return true;
        }
        return false;
    }
}
