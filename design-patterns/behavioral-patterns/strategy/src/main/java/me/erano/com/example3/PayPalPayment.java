package me.erano.com.example3;

public class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " TL PayPal ile ödendi: " + email);
    }
}
