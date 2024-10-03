package me.erano.com.example3;

public class BuyCryptoFacade {

    public void buyCryptocurrency(double amount, String currency) {

        DatabaseService dbService = new DatabaseService();
        User user = dbService.getUser(UIService.getLoggedInUserId());
        if (user.balance() < amount) {
            System.out.println("Insufficient balance to perform transaction");
            return;
        }
        CryptoFactory.getCryptoService(currency).buyCurrency(user, amount);
        MailService mailService = new MailService();
        mailService.sendConfirmationMail(user);
        System.out.println(amount + " of " + currency + " bought successfully!");

    }
}
