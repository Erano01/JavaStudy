package me.erano.com.example2;

public class CollateralBasedPricing implements LoanPricing {
    @Override
    public double calculateInterestRate(LoanApplicationModel app) {
        return app.isSecured() ? 10.0 : 14.0;
    }
}
