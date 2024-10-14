package me.erano.com.example1;

public class Button extends Widget{

    //next Handler
    private HelpHandler successor;

    public Button(HelpHandler nextHandler) {
        super(nextHandler);
        this.successor = nextHandler;
    }

    @Override
    public void handleHelp() {
        if (successor != null) {
            System.out.println("Button: Passing help request to successor.");
            successor.handleHelp();
        } else {
            System.out.println("Button: No successor to handle help request.");
        }
    }
}
