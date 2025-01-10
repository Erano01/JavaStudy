package me.erano.com.example1;

//Non-Terminal Expression
public class AlternationExpression implements RegularExpression {
    private final RegularExpression expr1;
    private final RegularExpression expr2;

    public AlternationExpression(RegularExpression expr1, RegularExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
