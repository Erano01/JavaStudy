package me.erano.com.example1;

public class GraphicFactory {

    public static Graphic getImage(String name) {
        return new ImageProxy(name);
    }
}
