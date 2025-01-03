package me.erano.com.example1;

import java.util.List;

//Invoker
//asks the command to carry out the request.
public class MenuItem {

    private List<Command> commandList;

    public void addCommand(Command cmd){
        commandList.add(cmd);
    }



}
