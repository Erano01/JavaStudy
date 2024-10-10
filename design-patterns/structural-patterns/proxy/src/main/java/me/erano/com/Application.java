package me.erano.com;

import me.erano.com.example1.Graphic;
import me.erano.com.example1.GraphicFactory;
import me.erano.com.example1.Point2D;
import me.erano.com.example1.proxies.ProtectionImageProxy;


public class Application {

    //there are 2 main type of proxy -> static or dynamic(implementing java.lang.reflect.InvocationHandler)
    //there are 4 type of proxy pattern whether your proxy is dynamic or static, you can implement one of them in 1 proxy or implement all of them in 1 proxy ->
    // 1-Remote Proxy -> in remote proxy the main point is getting objects outside of our api.can be used with gRPC, HTTP/REST, WebSockets, JMS, RMI etc.
    // 2-Virtual Proxy -> A virtual proxy creates expensive objects on demand. (for lazy init. objects)
    // 3-Protection Proxy ->  A protection proxy controls access to the original object. Protection proxies are useful when objects should have different access rights.
    // 4-Smart Reference Proxy -> caching real subject state or fields.
    public static void main(String[] args) {

        //Virtual + smart proxy /
        Graphic graphic = GraphicFactory.getImageFromVirtualSmartImageProxy("virtual_smart_image.png");
        graphic.setLocation(new Point2D(10,10));
        System.out.println("Image location :"+graphic.getLocation());
        graphic.render();

        //Dynamic + virtual + smart proxy
        Graphic graphic2 = GraphicFactory.getImageFromDynamicProxy("dynamic_virtual_smart_image.png");
        graphic2.setLocation(new Point2D(0,-10));
        System.out.println("Image location :"+graphic2.getLocation());
        graphic2.render();

        //Protection proxy
        Graphic imageProxyWithAccess = GraphicFactory.getImageFromProtectionImageProxy("test_image.jpg", true);
        imageProxyWithAccess.setLocation(new Point2D(10, 20));
        System.out.println("Location: " + imageProxyWithAccess.getLocation());
        imageProxyWithAccess.getPermissionAccess();
        imageProxyWithAccess.render();

        //Dynamic + protection proxy


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
