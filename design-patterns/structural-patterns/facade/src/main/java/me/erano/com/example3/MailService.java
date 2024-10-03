package me.erano.com.example3;

public class MailService {

    public void sendConfirmationMail(User user) {
        System.out.println("Sending mail to " + user.name());
    }

}
