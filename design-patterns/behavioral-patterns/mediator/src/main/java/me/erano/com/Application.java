package me.erano.com;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        // javax.swing.ButtonGroup & javax.swing.ButtonModel is best example for this pattern.
        ButtonGroup buttonGroup;
        ButtonModel buttonModel;

        //example 1
        AirTrafficControl tower = new Tower();

        Aircraft passenger1 = new PassengerAircraft(tower, "Yolcu Uçağı 1");
        Aircraft passenger2 = new PassengerAircraft(tower, "Yolcu Uçağı 2");
        Aircraft cargo1 = new CargoAircraft(tower, "Kargo Uçağı 1");

        passenger1.sendMessage("Piste iniş için izin istiyorum.");
        cargo1.sendMessage("Kalkış için hazır.");
        passenger2.sendMessage("Pist üzerinde duruyorum, iniş yok.");
    }

}
