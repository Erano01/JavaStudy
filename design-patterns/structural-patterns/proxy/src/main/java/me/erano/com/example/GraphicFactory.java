package me.erano.com.example;

import me.erano.com.example.proxies.DynamicVirtualSmartImageProxy;
import me.erano.com.example.proxies.VirtualSmartImageProxy;

import java.lang.reflect.Proxy;

public class GraphicFactory {

    public static Graphic getImageFromVirtualSmartImageProxy(String name) {
        return new VirtualSmartImageProxy(name);
    }

    public static Graphic getImageFromDynamicVirtualSmartProxy(String name) {
        return (Graphic) Proxy.newProxyInstance(
                GraphicFactory.class.getClassLoader(),
                new Class[] { Graphic.class },
                new DynamicVirtualSmartImageProxy(name)
        );
    }

}
