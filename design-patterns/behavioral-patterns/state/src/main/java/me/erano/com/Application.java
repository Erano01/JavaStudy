package me.erano.com;

import me.erano.com.example1.TCPClosed;
import me.erano.com.example1.TCPConnection;

public class Application {

    public static void main(String[] args) {

        //example 1
        TCPConnection connection = new TCPConnection(new TCPClosed());
        connection.open();  // "Opening connection." → state: TCPListen
        connection.acknowledge();   // "Connection established from listening state." → state: TCPEstablished
        connection.close(); // "Closing connection." → state: TCPClosed
        connection.acknowledge();   // "Cannot acknowledge, connection closed."
        connection.open();  // "Opening connection." → state: TCPListen


    }
}
