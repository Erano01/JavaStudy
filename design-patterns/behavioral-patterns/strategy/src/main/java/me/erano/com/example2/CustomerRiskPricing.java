package me.erano.com.example2;

public class CustomerRiskPricing implements LoanPricing {
    @Override
    public double calculateInterestRate(LoanApplicationModel app) {
        if (app.getCreditScore() >= 750) {
            return 9.5;
        } else if (app.getCreditScore() >= 650) {
            return 12.0;
        } else {
            return 16.0;
        }
    }
}
