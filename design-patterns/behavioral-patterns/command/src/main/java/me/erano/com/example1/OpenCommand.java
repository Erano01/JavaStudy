package me.erano.com.example1;

//ConcreteCommand
//defines a binding between a Receiver object and an action.
//implements Execute by invoking the corresponding operation(s) on Receiver.
public class OpenCommand implements Command{

    private Document document;

    public OpenCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.open();
    }

}
