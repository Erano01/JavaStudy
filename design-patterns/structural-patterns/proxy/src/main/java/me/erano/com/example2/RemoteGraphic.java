package me.erano.com.example2;

import me.erano.com.example1.Point2D;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Subject
public interface RemoteGraphic extends Remote {

    void setLocation(Point2D point2d) throws RemoteException;

    Point2D getLocation() throws RemoteException;

    void render() throws RemoteException;

}
