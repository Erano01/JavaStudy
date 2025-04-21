package me.erano.com.example1;

public class TCPListen implements TCPState {
    @Override
    public void open(TCPConnection conn) {
        System.out.println("Already in listening state.");
    }

    @Override
    public void close(TCPConnection conn) {
        System.out.println("Closing connection from listening state.");
        conn.setState(new TCPClosed());
    }

    @Override
    public void acknowledge(TCPConnection conn) {
        System.out.println("Connection established from listening state.");
        conn.setState(new TCPEstablished());
    }
}
