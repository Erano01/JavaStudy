package me.erano.com.example1;

//Non-Terminal Expression
// sequence ::- expression '&' expression
public class SequenceExpression extends RegularExpression {

    private RegularExpression expression1;
    private RegularExpression expression2;

    private SequenceExpression(String context) {
        super(context);
    }
    public SequenceExpression(RegularExpression expression1, RegularExpression expression2){
        super(new String(expression1.getContext()+ " & " +expression2.getContext()));
        this.expression1 = expression1;
        this.expression2 = expression2;

    }
    @Override
    public boolean interpret(RegularExpression argExpression) {
        if(argExpression.getContext().contains(expression1.getContext()) &
            argExpression.getContext().contains(expression2.getContext())){
            return true;
        }
        return false;
    }
}