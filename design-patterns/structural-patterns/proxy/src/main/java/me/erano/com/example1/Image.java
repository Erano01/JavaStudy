package me.erano.com.example1;


import java.util.List;

//Real Subject
public class Image implements Graphic{

    private Point2D location;
    private String name;
    private final List<String> permissionAccess = List.of("Admin", "Moderator");

    public Image(String filename) {
        //Loads image from file on disk
        System.out.println("Loaded from disk:"+filename);
        name = filename;
    }

    @Override
    public void setLocation(Point2D point2d) {
        location = point2d;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public List<String> getPermissionAccess(){
        return this.permissionAccess;
    }

    @Override
    public void render() {
        //renders to screen
        System.out.println("Rendered "+this.name);
    }


}
