package me.erano.com.example3;

//Context
public class ShoppingCart {
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        if (payment == null) {
            throw new IllegalStateException("Ödeme stratejisi ayarlanmadı!");
        }
        payment.pay(amount);
    }
}
