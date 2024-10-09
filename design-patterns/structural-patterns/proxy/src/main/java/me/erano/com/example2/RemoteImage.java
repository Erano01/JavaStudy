package me.erano.com.example2;

import me.erano.com.example1.Point2D;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImage extends UnicastRemoteObject implements RemoteGraphic {

    private Point2D location;
    private String name;

    public RemoteImage(String filename) throws RemoteException {
        super();  // UnicastRemoteObject'in constructor call
        System.out.println("Loaded from disk: " + filename);
        this.name = filename;
    }

    @Override
    public void setLocation(Point2D point2d) throws RemoteException {
        location = point2d;
    }

    @Override
    public Point2D getLocation() throws RemoteException {
        return location;
    }

    @Override
    public void render() throws RemoteException {
        System.out.println("Rendered " + this.name);
    }
}
