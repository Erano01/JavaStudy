package me.erano.com.example4.product;

//TeXText as the Product
public class TeXText {
    private StringBuilder content = new StringBuilder();

    public void append(char c) {
        content.append(c).append(' ');
    }

    public void append(String s) {
        content.append(s).append(' ');
    }

    public void appendParagraph() {
        content.append("\n");
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
