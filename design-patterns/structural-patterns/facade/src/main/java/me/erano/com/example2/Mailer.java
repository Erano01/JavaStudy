package me.erano.com.example2;

public class Mailer {
    private static final Mailer MAILER = new Mailer();

    public static Mailer getMailer() {
        return MAILER;
    }

    private Mailer() {

    }

    public boolean send(Email email) {
        return true;
    };
}
