package me.erano.com.example1;

public class Dialog extends Widget{

    //next Handler
    private HelpHandler successor;

    public Dialog(HelpHandler nextHandler) {
        super(nextHandler);
        this.successor = nextHandler;
    }

    @Override
    public void handleHelp() {
        if (successor != null) {
            System.out.println("Dialog: Passing help request to successor.");
            successor.handleHelp();
        } else {
            System.out.println("Dialog: No successor to handle help request.");
        }
    }
}
