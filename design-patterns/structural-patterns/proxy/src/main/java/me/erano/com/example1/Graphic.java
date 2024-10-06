package me.erano.com.example1;

import java.awt.geom.Point2D;

//Subject
public interface Graphic {

    void setLocation(Point2D point2d);

    Point2D getLocation();

    void render();

}