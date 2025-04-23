package me.erano.com.example3;

public class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " TL kredi kartı ile ödendi: " + cardNumber);
    }
}
