package me.erano.com;

//Abstract Mediator
public interface AirTrafficControl {
    void sendMessage(String message, Aircraft sender);
    void registerAircraft(Aircraft aircraft);
}
