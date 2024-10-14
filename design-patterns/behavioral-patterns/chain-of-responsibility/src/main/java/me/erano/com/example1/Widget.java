package me.erano.com.example1;

//abstract handler that extends handler
public abstract class Widget implements HelpHandler{

    //next handler
    private HelpHandler successor;

    public Widget(HelpHandler successor) {
        this.successor = successor;
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
