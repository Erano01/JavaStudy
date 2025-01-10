package me.erano.com.example1;

//Terminal Expression
public class LiteralExpression implements RegularExpression {
    private String literal;

    public LiteralExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(literal);
    }
}
