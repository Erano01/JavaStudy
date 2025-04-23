package me.erano.com.example2;

//Abstract Strategy
public interface LoanPricing {
    double calculateInterestRate(LoanApplicationModel applicationModel);
}
