package me.erano.com.example5;

import java.lang.reflect.Proxy;

import me.erano.com.example1.Graphic;

//Factory to get image objects. 
public class DynamicGraphicFactory {
	//We'll provide proxy to caller instead of real object
	
	public static Graphic getImage(String name) {
		return (Graphic) Proxy.newProxyInstance(DynamicGraphicFactory.class.getClassLoader(), new Class[]{Graphic.class},
				new ImageInvocationHandler(name)); 
	}
}