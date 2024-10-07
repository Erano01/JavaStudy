package me.erano.com;

import me.erano.com.example1.Graphic;
import me.erano.com.example1.GraphicFactory;
import me.erano.com.example1.Point2D;
import me.erano.com.example5.DynamicGraphicFactory;


public class Application {

    //there are 4 type of proxy pattern ->
    // 1-Remote Proxy, 2-Virtual Proxy, 3-Protection Proxy, 4-Smart Reference Proxy
    // 5- Dynamic Proxy??? -> java.lang.reflect.InvocationHandler
    public static void main(String[] args) {

//        ex1 -> virtual proxy.
        Graphic graphic = GraphicFactory.getImage("A1.bmp");

        graphic.setLocation(new Point2D(10,10));
        System.out.println("Image location :"+graphic.getLocation());
        System.out.println("rendering image now.....");
        graphic.render();

//        ex2 -> Remote Proxy

//        ex3 -> Protection Proxy

//        ex4 -> Smart Reference Proxy

//        ex5 -> Dynamic Proxy
        System.out.println("*****************************");
        System.out.println("Dynamic Proxy -> "+"\n");
        Graphic graphic1 = DynamicGraphicFactory.getImage("A.bmp");
        graphic1.setLocation(new Point2D(-10,0));
        System.out.println(graphic1.getLocation()); //returns null

        graphic1.render();

        // hibernate uses proxy to load collections of value types. For example,
        // when you mapping your entities sometimes u can use Collection so in that situation
        // field you marked as candidate for lazy loading will be handled one of hibernates virtual proxy.

        // Spring framework also uses proxy pattern to provide support for features like transaction,
        // caching and general AOP support.

        //Hibernate & Spring both can create proxies for classes which do not implement any interface.
        //They use third party frameworks like cglib, aspectJ to create dynamic proxies
        // (remember, Java's dynamic proxy needs interface) at runtime.
    }
}
