package me.erano.com.example1;

//abstract handler that extends handler
public abstract class Widget implements HelpHandler{

    //next handler
    protected HelpHandler successor;

    protected String handleInfo;

    public Widget(HelpHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleHelp(HelpRequest helpRequest) {
        if (!showHelp(helpRequest) && successor != null) {
            successor.handleHelp(helpRequest);
        }
    }

    @Override
    public String getHandleInfo() {
        return handleInfo;
    }

    protected abstract boolean showHelp(HelpRequest helpRequest);
}
