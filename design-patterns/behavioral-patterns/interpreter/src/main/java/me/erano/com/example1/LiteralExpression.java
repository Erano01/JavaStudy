package me.erano.com.example1;

//Terminal Expression
// Literal Expression -> Kelimenin tam anlamıyla ifadeler
// dog, cat, raining etc
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
