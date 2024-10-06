package me.erano.com;

import me.erano.com.example1.Graphic;
import me.erano.com.example1.GraphicFactory;
import me.erano.com.example1.Image;

import java.awt.geom.Point2D;

public class Application {

    //there are 4 type of proxy pattern ->
    // 1-Remote Proxy, 2-Virtual Proxy, 3-Protection Proxy, 4-Smart Reference Proxy
    // 5- Dynamic Proxy???
    public static void main(String[] args) {

//        ex1 -> we used virtual proxy.
        Graphic img = GraphicFactory.getImage("A1.bmp");

        img.setLocation(new Point2D() {
            @Override
            public double getX() {
                return 10;
            }

            @Override
            public double getY() {
                return 10;
            }

            @Override
            public void setLocation(double x, double y) {

            }
        });
        System.out.println("Image location :"+img.getLocation());
        System.out.println("rendering image now.....");
        img.render();

//        ex2

//        ex3


    }
}
