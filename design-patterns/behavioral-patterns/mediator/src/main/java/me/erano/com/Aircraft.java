package me.erano.com;

//Colleague
public abstract class Aircraft {
    protected AirTrafficControl tower;
    protected String name;

    public Aircraft(AirTrafficControl tower, String name) {
        this.tower = tower;
        this.name = name;
        tower.registerAircraft(this);
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
