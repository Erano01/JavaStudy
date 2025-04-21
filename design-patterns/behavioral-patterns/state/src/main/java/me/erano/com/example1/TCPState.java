package me.erano.com.example1;

public interface TCPState {
    void open(TCPConnection conn);
    void close(TCPConnection conn);
    void acknowledge(TCPConnection conn);
}
