package me.erano.com.example1;

//Non-Terminal Expression
// repetition expression -> tekrarlanan ifadeler
public class RepetitionExpression implements RegularExpression {
    private RegularExpression expression;

    public RepetitionExpression(RegularExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(String context) {
        String[] words = context.split("\\s+"); // Cümleyi kelimelere böl
        for (String word : words) {
            if (expression.interpret(word)) {
                return true; // Alt ifade bir kez eşleştiyse true
            }
        }
        return false;
    }
}
