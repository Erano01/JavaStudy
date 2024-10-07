package me.erano.com.example1;

import me.erano.com.example1.Point2D;

//Subject
public interface Graphic {

    void setLocation(Point2D point2d);

    Point2D getLocation();

    void render();

}