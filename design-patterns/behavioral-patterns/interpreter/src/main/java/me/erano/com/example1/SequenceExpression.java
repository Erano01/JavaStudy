package me.erano.com.example1;

//Non-Terminal Expression
public class SequenceExpression implements RegularExpression {
    private final RegularExpression expr1;
    private final RegularExpression expr2;

    public SequenceExpression(RegularExpression expr1, RegularExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        // İki ifade de sırayla mevcut olmalı.
        return context.contains(expr1.toString()) && context.contains(expr2.toString());
    }
}