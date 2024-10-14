package me.erano.com.example1;

public class Window implements HelpHandler{

    //next Handler
    private HelpHandler successor;

    public void setNextHandler(HelpHandler nextHandler) {
        this.successor = nextHandler;
    }

    @Override
    public void handleHelp() {
        if (successor != null) {
            System.out.println("Widget: Passing help request to successor.");
            successor.handleHelp();
        } else {
            System.out.println("Widget: No successor to handle help request.");
        }
    }
}
