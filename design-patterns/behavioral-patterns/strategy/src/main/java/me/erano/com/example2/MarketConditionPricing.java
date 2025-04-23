package me.erano.com.example2;

public class MarketConditionPricing implements LoanPricing {
    private double baseRate; // örneğin merkez bankası faizi

    public MarketConditionPricing(double baseRate) {
        this.baseRate = baseRate;
    }

    @Override
    public double calculateInterestRate(LoanApplicationModel loanApplicationModel) {
        return baseRate + 4.0;
    }
}
