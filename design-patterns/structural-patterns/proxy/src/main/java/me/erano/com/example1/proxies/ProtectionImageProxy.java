package me.erano.com.example1.proxies;

import me.erano.com.example1.Graphic;
import me.erano.com.example1.Image;
import me.erano.com.example1.Point2D;

import java.util.List;

//proxy
public class ProtectionImageProxy implements Graphic {

    private Image image;
    private String filename;
    private boolean accessGranted;

    public ProtectionImageProxy(String filename, boolean accessGranted) {
        this.filename = filename;
        this.accessGranted = accessGranted;
    }

    @Override
    public void setLocation(Point2D point2d) {
        if (accessGranted) {
            if (image == null) {
                image = new Image(filename);  // Lazy loading
            }
            image.setLocation(point2d);
        } else {
            System.out.println("Access Denied: Cannot set location.");
        }
    }

    @Override
    public Point2D getLocation() {
        if (image != null) {
            return image.getLocation();
        }
        return null; // or default location if desired
    }
    @Override
    public List<String> getPermissionAccess() {
        if (image != null) {
            return image.getPermissionAccess();
        }
        return null;
    }

    @Override
    public void render() {
        if (accessGranted) {
            if (image == null) {
                image = new Image(filename);  // Lazy loading
            }
            image.render();
        } else {
            System.out.println("Access Denied: Cannot render the image.");
        }
    }


}
