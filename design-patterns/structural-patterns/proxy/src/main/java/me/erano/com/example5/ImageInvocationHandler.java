package me.erano.com.example5;

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
			setLocationMethod = Image.class.getMethod("setLocation", Point2D.class);
			getLocationMethod = Image.class.getMethod("getLocation");
			renderMethod = Image.class.getMethod("render");
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Method not found: " + e.getMessage());
		}
	}

	public ImageInvocationHandler(String filename) {
		this.filename = filename;
	}

	// Core invocation method for handling method calls on the proxy
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

	// Lazily create the real Image object when needed
	private void createImageIfNecessary() {
		if (image == null) {
			image = new Image(filename);
			// Apply the stored location to the newly created image (if location was set earlier)
			if (location != null) {
				image.setLocation(location);
			}
		}
	}

	// Handle setLocation method
	private Object handleSetLocation(Object[] args) {
		// Check for correct argument type
		if (args[0] instanceof Point2D) {
			location = (Point2D) args[0];
		} else {
			throw new IllegalArgumentException("Invalid argument type for setLocation");
		}

		// If the image is already created, update its location directly
		if (image != null) {
			image.setLocation(location);
		}
		return null;
	}

	// Handle getLocation method
	private Point2D handleGetLocation() {
		// If the real image is already created, delegate to it
		if (image != null) {
			return image.getLocation();
		} else {
			// Otherwise, return the stored location in the proxy (or default if none set)
			return location != null ? location : new Point2D(0, 0); // Default to (0, 0) if not set
		}
	}

	// Handle render method
	private Object handleRender() {
		// Ensure the real image is created before rendering
		createImageIfNecessary();
		image.render();
		return null;
	}
	
}
