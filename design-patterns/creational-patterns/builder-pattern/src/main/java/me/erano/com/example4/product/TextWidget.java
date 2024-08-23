package me.erano.com.example4.product;

//TextWidget as the Product
public class TextWidget {
    private StringBuilder content = new StringBuilder();

    public void append(char c) {
        content.append(c).append(' ');
    }

    public void appendParagraph() {
        content.append("\n");
    }

    public void append(String s) {
        content.append(s).append(' ');
    }

    @Override
    public String toString() {
        return content.toString();
    }
}