package me.erano.com.example1;

//Request for starting chain of responsibility logic (this class is not needed for chain of responsibility uml structure)
public class HelpRequest {

    private HelpHandler handler;

    private final int statusCode;

    public HelpRequest(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return handler == null
                ? "Unprocessed Request with status code: " + statusCode
                : "Request returning " + statusCode + " status code, handle info: " + handler.getHandleInfo();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setHandler(HelpHandler handler) {
        this.handler = handler;
    }
}
