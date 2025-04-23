package me.erano.com.example2;

// Model for application form
public class LoanApplicationModel {
    private double creditScore;
    private double income;
    private double debtToIncomeRatio;
    private LoanType loanType;
    private boolean isSecured;
    private int loanTermInMonths;

    public LoanApplicationModel(){

    }

    public LoanApplicationModel(double creditScore, double income, double debtToIncomeRatio, LoanType loanType, boolean isSecured, int loanTermInMonths) {
        this.creditScore = creditScore;
        this.income = income;
        this.debtToIncomeRatio = debtToIncomeRatio;
        this.loanType = loanType;
        this.isSecured = isSecured;
        this.loanTermInMonths = loanTermInMonths;
    }

    public enum LoanType {
        PERSONAL, AUTO, MORTGAGE, COMMERCIAL
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDebtToIncomeRatio() {
        return debtToIncomeRatio;
    }

    public void setDebtToIncomeRatio(double debtToIncomeRatio) {
        this.debtToIncomeRatio = debtToIncomeRatio;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public boolean isSecured() {
        return isSecured;
    }

    public void setSecured(boolean secured) {
        isSecured = secured;
    }

    public int getLoanTermInMonths() {
        return loanTermInMonths;
    }

    public void setLoanTermInMonths(int loanTermInMonths) {
        this.loanTermInMonths = loanTermInMonths;
    }


}
