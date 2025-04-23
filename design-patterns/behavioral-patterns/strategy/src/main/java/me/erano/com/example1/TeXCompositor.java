package me.erano.com.example1;

public class TeXCompositor implements Compositor {
    @Override
    public void compose(String[] text) {
        System.out.println("TeXCompositor: Optimizing paragraph as a whole:");
        System.out.println(String.join(" ", text));
    }
}
