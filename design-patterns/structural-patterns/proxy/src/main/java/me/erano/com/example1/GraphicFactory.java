package me.erano.com.example1;

import me.erano.com.example1.proxies.DynamicVirtualSmartImageProxy;
import me.erano.com.example1.proxies.VirtualSmartImageProxy;
import me.erano.com.example2.RemoteGraphic;
import me.erano.com.example2.RemoteImage;

import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GraphicFactory {

    public static Graphic getImageFromVirtualSmartImageProxy(String name) {
        return new VirtualSmartImageProxy(name);
    }

    public static Graphic getImageFromDynamicVirtualSmartProxy(String name) {
        return (Graphic) Proxy.newProxyInstance(
                GraphicFactory.class.getClassLoader(),
                new Class[] { Graphic.class },
                new DynamicVirtualSmartImageProxy(name)
        );
    }

    private static boolean isServerRunning = false;

    // Start the RMI server in a separate thread
    private static void startRMIServer() {
        if (!isServerRunning) {
            new Thread(() -> {
                try {
                    Registry registry = LocateRegistry.createRegistry(1099); // default RMI port
                    // Here, we can add more images to the registry if needed
                    RemoteImage remoteImage = new RemoteImage("remote_image.png");
                    registry.rebind("remote_image", remoteImage); // binding name
                    System.out.println("Remote Image Server is ready.");
                    isServerRunning = true;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    //registry or whatever parameter you decide. i let you decide!
    public static RemoteGraphic getImageFromRemoteProxy(String name) {
        startRMIServer(); // Start the RMI server if not already running
        try {
            Registry registry = LocateRegistry.getRegistry("localhost"); // or any host
            return (RemoteGraphic) registry.lookup(name); // name is the binding name
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
