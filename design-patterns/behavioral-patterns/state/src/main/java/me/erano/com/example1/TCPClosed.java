package me.erano.com.example1;

public class TCPClosed implements TCPState {
    public void open(TCPConnection conn) {
        System.out.println("Opening connection.");
        conn.setState(new TCPListen());
    }
    public void close(TCPConnection conn) {
        System.out.println("Already closed.");
    }
    public void acknowledge(TCPConnection conn) {
        System.out.println("Cannot acknowledge, connection closed.");
    }
}
