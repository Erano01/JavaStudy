package me.erano.com.example1;

import java.util.List;

//Subject
public interface Graphic {

    void setLocation(Point2D point2d);

    Point2D getLocation();

    void render();

    List<String> getPermissionAccess();

}