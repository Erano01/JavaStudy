package me.erano.com.example5;

import me.erano.com.example1.Graphic;
import me.erano.com.example1.Image;
import me.erano.com.example1.Point2D;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;



//Implement invocation handler. Your "proxy" code goes here.
public class ImageInvocationHandler implements InvocationHandler{

	private final String filename;
	private Point2D location;
	private Image image;

	// Cache Methods for comparison
	private static final Method setLocationMethod;
	private static final Method getLocationMethod;
	private static final Method renderMethod;

	// Static block to initialize Method objects for caching
	static {
		try {
			setLocationMethod = Graphic.class.getMethod("setLocation", Point2D.class);
			getLocationMethod = Graphic.class.getMethod("getLocation");
			renderMethod = Graphic.class.getMethod("render");
		} catch (NoSuchMethodException e) {
			throw new NoSuchMethodError(e.getMessage());
		}
	}

	public ImageInvocationHandler(String filename) {
		this.filename = filename;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoking method: " + method.getName());

		if (method.equals(setLocationMethod)) {
			return handleSetLocation(args);
		} else if (method.equals(getLocationMethod)) {
			return handleGetLocation();
		} else if (method.equals(renderMethod)) {
			return handleRender();
		}

		return null; // For any other methods, return null
	}

	private Object handleRender() {
		if (image == null) {
			System.out.println("Creating Image object for the first time.");
			image = new Image(filename);
			if (location != null) {
				System.out.println("Setting location to newly created Image: " + location);
				image.setLocation(location);
			}
		}
		image.render();
		return null;
	}

	private Point2D handleGetLocation() {
		if (image != null) {
			System.out.println("Getting location from Image object.");
			return image.getLocation();
		} else {
			System.out.println("Returning cached location from Proxy: " + location);
			return this.location;
		}
	}

	private Object handleSetLocation(Object[] args) {
		Point2D point2D = (Point2D) args[0];
		if (image != null) {
			System.out.println("Setting location in Image object.");
			image.setLocation(point2D);
		} else {
			System.out.println("Caching location in Proxy: " + point2D);
			this.location = point2D;
		}
		return null;
	}
}
