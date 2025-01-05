package me.erano.com;

import me.erano.com.example1.*;
import me.erano.com.example2.AddMemberCommand;
import me.erano.com.example2.Command;
import me.erano.com.example2.EWSService;
import me.erano.com.example2.MailTasksRunner;

import java.util.Arrays;

//Receiver
//knows how to perform the operations associated with carrying out a request. Any class may serve as a Receiver.
public class Application {

    public static void main(String[] args) throws InterruptedException{

        //ex1
        Document document = new Document(Arrays.asList("line1", "line2", "line3"));

        me.erano.com.example1.Command openCommand = (me.erano.com.example1.Command) new OpenCommand(document);
        me.erano.com.example1.Command closeCommand = (me.erano.com.example1.Command) new CloseCommand(document);
        me.erano.com.example1.Command copyCommand = (me.erano.com.example1.Command) new CopyCommand(document, "line1");
        me.erano.com.example1.Command pasteCommand = (me.erano.com.example1.Command) new PasteCommand(document);

        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Open Document", openCommand));
        menu.addMenuItem(new MenuItem("Close Document", closeCommand));
        menu.addMenuItem(new MenuItem("Copy Line", copyCommand));
        menu.addMenuItem(new MenuItem("Paste Line", pasteCommand));
        menu.showMenu();
        menu.select(1);
        menu.select(3);
        menu.select(4);
        menu.select(2);

        //ex2
        EWSService service = new EWSService();
        Command c1 = new AddMemberCommand("a@a.com", "spam", service);
        MailTasksRunner.getInstance().addCommand(c1);
        Command c2 = new AddMemberCommand("b@b", "spam", service);
        MailTasksRunner.getInstance().addCommand(c2);
        Thread.sleep(3000);
        MailTasksRunner.getInstance().shutdown();

        //java.lang.Runnable interface represents the Command Design Pattern.
    }
}
