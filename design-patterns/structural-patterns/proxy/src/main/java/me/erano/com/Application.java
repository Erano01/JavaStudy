package me.erano.com;

import me.erano.com.example.Graphic;
import me.erano.com.example.GraphicFactory;
import me.erano.com.example.Point2D;


public class Application {

    //there are 4 type of proxy pattern ->
    // 1-Remote Proxy ->
    // 2-Virtual Proxy ->
    // 3-Protection Proxy ->
    // 4-Smart Reference Proxy -> caching real subject state or fields.
    // 5-Dynamic Proxy -> implementing java.lang.reflect.InvocationHandler
    public static void main(String[] args) {

        //virtual + smart proxy
        Graphic graphic = GraphicFactory.getImageFromVirtualSmartImageProxy("virtual_smart_image.png");
        graphic.setLocation(new Point2D(10,10));
        System.out.println("Image location :"+graphic.getLocation());
        graphic.render();

        Graphic graphic2 = GraphicFactory.getImageFromDynamicVirtualSmartProxy("dynamic_virtual_smart_image.png");
        graphic2.setLocation(new Point2D(0,-10));
        System.out.println("Image location :"+graphic2.getLocation());
        graphic2.render();

        // Examples from APIs ->
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
