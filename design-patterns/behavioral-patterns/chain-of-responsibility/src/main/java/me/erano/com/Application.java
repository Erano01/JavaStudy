package me.erano.com;

import me.erano.com.example1.*;
import me.erano.com.example2.*;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        //ex1
        Dialog dialog = new Dialog(null);
        Button button = new Button(dialog);
        Window window = new Window(button);
        Window window1 = new Window(window);

        HelpRequest request = new HelpRequest(3); // 3 -> Dialog
        System.out.println(request);

        HelpHandler handler = window1;
        handler.handleHelp(request); // Start chain

        System.out.println(request);

        //ex2
        Director director = new Director(null);
        Manager manager = new Manager(director);
        Lead lead = new Lead(manager);
        LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.Sick)
                .from(LocalDate.now()).to(LocalDate.of(2018, 2, 28))
                .build();
        System.out.println(application);
        System.out.println("**************************************************");
        LeaveApprover approver = lead;
        approver.processLeaveApplication(application); //start chain
        System.out.println(application);

        //ex3 -> Probably the best example of chain of responsibility is servlet filters.
        //Each filter gets a chance to handle incoming requests and passes it down the chain once its work is done.
        //All servlet filters implement the javax.servlet.Filter interface which defines doFilter() method.


    }
}
