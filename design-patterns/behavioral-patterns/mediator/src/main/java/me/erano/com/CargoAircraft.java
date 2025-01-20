package me.erano.com;

public class CargoAircraft extends Aircraft {
    public CargoAircraft(AirTrafficControl tower, String name) {
        super(tower, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " gönderiyor: " + message);
        tower.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " aldı: " + message);
    }
}