package me.erano.com.example1;

public class TCPConnection {
    private TCPState state;

    public TCPConnection(TCPState initialState) {
        this.state = initialState;
    }

    public void setState(TCPState state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }

    public void acknowledge() {
        state.acknowledge(this);
    }
}
