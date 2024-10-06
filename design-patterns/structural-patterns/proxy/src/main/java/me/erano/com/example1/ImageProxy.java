package me.erano.com.example1;

import java.awt.geom.Point2D;

//Proxy
public class ImageProxy implements Graphic{

    private String name;

    private Image image;

    private Point2D location;

    public ImageProxy(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(Point2D point2d) {
        if(image != null) {
            image.setLocation(point2d);
        } else {
            location = point2d;
        }
    }

    @Override
    public Point2D getLocation() {
        if(image != null) {
            return image.getLocation();
        }
        return location;
    }

    @Override
    public void render() {
        if(image == null) {
            image = new Image(name);
            if(location != null) {
                image.setLocation(location);
            }
        }
        image.render();

    }
}
