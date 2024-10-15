package me.erano.com.example1;

//Concrete Handler
public class Dialog extends Widget{

    public Dialog(HelpHandler successor) {
        super(successor);
    }

    @Override
    protected boolean showHelp(HelpRequest helpRequest) {
        if (helpRequest.getStatusCode() == 3) {
            helpRequest.setHandler(this);
            this.handleInfo = "statusCode +"+ helpRequest.getStatusCode() +": Displaying help for Dialog.";
            return true;
        }
        return false;
    }
}
