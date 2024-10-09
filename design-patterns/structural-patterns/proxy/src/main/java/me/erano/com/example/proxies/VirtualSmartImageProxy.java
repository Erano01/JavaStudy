package me.erano.com.example.proxies;

import me.erano.com.example.Graphic;
import me.erano.com.example.Image;
import me.erano.com.example.Point2D;

//Proxy -> we used Virtual proxy + Smart reference proxy features.
public class VirtualSmartImageProxy implements Graphic {

    private final String name;

    private Image image;

    private Point2D location;

    public VirtualSmartImageProxy(String name) {
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
