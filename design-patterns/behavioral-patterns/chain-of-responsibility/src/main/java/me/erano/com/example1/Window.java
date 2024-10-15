package me.erano.com.example1;

//concrete handler
public class Window implements HelpHandler{

    private HelpHandler successor;

    private String handleInfo;

    public Window(HelpHandler successor) {
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

    protected boolean showHelp(HelpRequest helpRequest) {
        if (helpRequest.getStatusCode() == 1) {
            helpRequest.setHandler(this);
            handleInfo = "statusCode +"+ helpRequest.getStatusCode() +": Displaying help for Window.";
            return true;
        }
        return false;
    }
}
