package me.erano.com;

import me.erano.com.example1.ArrayCompositor;
import me.erano.com.example1.Composition;
import me.erano.com.example1.SimpleCompositor;
import me.erano.com.example1.TeXCompositor;
import me.erano.com.example2.*;

public class Application {
    public static void main(String[] args) {

        //example 1 - gof
        /*
        String[] paragraph = {
                "Strategy", "design", "pattern", "lets", "the", "algorithm",
                "vary", "independently", "from", "clients", "that", "use", "it."
        };

        Composition composition = new Composition(new SimpleCompositor());
        composition.repair(paragraph);

        System.out.println("\nSwitching to TeXCompositor:\n");
        composition.setCompositor(new TeXCompositor());
        composition.repair(paragraph);

        System.out.println("\nSwitching to ArrayCompositor:\n");
        composition.setCompositor(new ArrayCompositor());
        composition.repair(paragraph);

         */

        //example 2 - banking loan pricing algorithms
        LoanApplicationModel loanApplicationModel = new LoanApplicationModel();
        loanApplicationModel.setCreditScore(720);
        loanApplicationModel.setIncome(5000);
        loanApplicationModel.setDebtToIncomeRatio(0.3);
        loanApplicationModel.setLoanType(LoanApplicationModel.LoanType.PERSONAL);
        loanApplicationModel.setSecured(false);
        loanApplicationModel.setLoanTermInMonths(36);

        LoanInterestRate context1 = new LoanInterestRate(new CustomerRiskPricing());
        System.out.println("Customer Risk Rate: " + context1.getRate(loanApplicationModel));

        LoanInterestRate context2 = new LoanInterestRate(new MarketConditionPricing(8.5));
        System.out.println("Market Condition Rate: " + context2.getRate(loanApplicationModel));

        LoanInterestRate context3 = new LoanInterestRate(new CollateralBasedPricing());
        System.out.println("Collateral Based Rate: " + context3.getRate(loanApplicationModel));

    }
}
