package me.erano.com;

import java.util.ArrayList;
import java.util.List;

//Concrete Mediator
public class Tower implements AirTrafficControl {
    private List<Aircraft> aircrafts = new ArrayList<>();

    @Override
    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public void sendMessage(String message, Aircraft sender) {
        for (Aircraft aircraft : aircrafts) {
            // Mesaj gönderen kendisi olmasın
            if (aircraft != sender) {
                aircraft.receiveMessage(message);
            }
        }
    }
}