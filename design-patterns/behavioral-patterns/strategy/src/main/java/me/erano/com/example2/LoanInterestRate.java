package me.erano.com.example2;

//Context class
public class LoanInterestRate {

    private LoanPricing loanPricing;

    public LoanInterestRate(LoanPricing loanPricing) {
        this.loanPricing = loanPricing;
    }

    public double getRate(LoanApplicationModel loanApplicationModel) {
        if (loanPricing == null) throw new IllegalStateException("Strategy not set.");
        return loanPricing.calculateInterestRate(loanApplicationModel);
    }
}
