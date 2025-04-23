package me.erano.com.example1;

public class SimpleCompositor implements Compositor {
    @Override
    public void compose(String[] text) {
        System.out.println("SimpleCompositor: Breaking text line by line:");
        for (String line : text) {
            System.out.println(line);
        }
    }
}
