package me.erano.com.example1;

public class ArrayCompositor implements Compositor {
    @Override
    public void compose(String[] text) {
        System.out.println("ArrayCompositor: Breaking into fixed number of words per line:");
        int wordsPerLine = 3;
        for (int i = 0; i < text.length; i++) {
            if (i > 0 && i % wordsPerLine == 0) {
                System.out.println();
            }
            System.out.print(text[i] + " ");
        }
        System.out.println();
    }
}
