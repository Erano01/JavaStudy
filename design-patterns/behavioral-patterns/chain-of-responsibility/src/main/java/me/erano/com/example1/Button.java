package me.erano.com.example1;

//Concrete handler
public class Button extends Widget{

    public Button(HelpHandler successor) {
        super(successor);
    }

    @Override
    protected boolean showHelp(HelpRequest helpRequest) {
        if (helpRequest.getStatusCode() == 2) {
            helpRequest.setHandler(this);
            this.handleInfo = "statusCode +"+ helpRequest.getStatusCode() +": Displaying help for Button.";
            return true;
        }
        return false;
    }
}
