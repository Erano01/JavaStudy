package me.erano.com.example1;

import java.util.List;

//Invoker
//asks the command to carry out the request.
//The Invoker, often a remote control, is the one responsible for initiating command execution.
//It holds a reference to a command but doesn’t delve into the specifics of how each command works.
//It’s like a button that, when pressed, makes things happen.
public class MenuItem {
    private String name;
    private Command command;

    public MenuItem(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public void click() {
        System.out.println("Executing " + name);
        command.execute();
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
