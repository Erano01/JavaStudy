package me.erano.com;

import me.erano.com.example2.AddMemberCommand;
import me.erano.com.example2.Command;
import me.erano.com.example2.EWSService;
import me.erano.com.example2.MailTasksRunner;

//Receiver
//knows how to perform the operations associated with carrying out a request. Any class may serve as a Receiver.
public class Application {

    public static void main(String[] args) throws InterruptedException{

        //ex1

        //ex2
        EWSService service = new EWSService();
        Command c1 = new AddMemberCommand("a@a.com", "spam", service);
        MailTasksRunner.getInstance().addCommand(c1);
        Command c2 = new AddMemberCommand("b@b", "spam", service);
        MailTasksRunner.getInstance().addCommand(c2);
        Thread.sleep(3000);
        MailTasksRunner.getInstance().shutdown();

        //ex3

        //ex4


        //ex5



        //java.lang.Runnable interface represents the Command Design Pattern.
    }
}
