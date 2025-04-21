package me.erano.com.example1;

public class TCPEstablished implements TCPState {
    public void open(TCPConnection conn) {
        System.out.println("Already established.");
    }
    public void close(TCPConnection conn) {
        System.out.println("Closing connection.");
        conn.setState(new TCPClosed());
    }
    public void acknowledge(TCPConnection conn) {
        System.out.println("Acknowledged.");
    }
}
