package me.erano.com.example1;

//ConcreteCommand
//defines a binding between a Receiver object and an action.
//implements Execute by invoking the corresponding operation(s) on Receiver.
public class OpenCommand implements Command{



    private MenuItem receiver;

    @Override
    public void execute() {
        receiver.open();
    }

}
