package me.erano.com.example1;

import me.erano.com.example1.proxies.DynamicImageProxy;
import me.erano.com.example1.proxies.ProtectionImageProxy;
import me.erano.com.example1.proxies.VirtualSmartImageProxy;

import java.lang.reflect.Proxy;

public class GraphicFactory {

    public static Graphic getImageFromVirtualSmartImageProxy(String name) {
        return new VirtualSmartImageProxy(name);
    }

    public static Graphic getImageFromDynamicProxy(String name) {
        return (Graphic) Proxy.newProxyInstance(
                GraphicFactory.class.getClassLoader(),
                new Class[] { Graphic.class },
                new DynamicImageProxy(name)
        );
    }

    public static Graphic getImageFromProtectionImageProxy(String name, boolean accessGranted){
        return new ProtectionImageProxy(name, accessGranted);
    }


}
