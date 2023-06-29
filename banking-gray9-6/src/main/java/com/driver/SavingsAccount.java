package com.driver;

public class SavingsAccount extends BankAccount{
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if(amount > maxWithdrawalLimit){
            throw  new RuntimeException("Maximum Withdraw Limit Exceed");
        }
        // 2. "Insufficient Balance" : If the amount exceeds balance
        else if (amount > super.getBalance()) {
            throw new RuntimeException("Maximum Withdraw Limit Exceed");
        } else {
            super.withdraw(amount);
        }

    }


    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = (getBalance() * rate * years)/100;
        double finalAmount = getBalance() + simpleInterest;
        return finalAmount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double factor = Math.pow((1 + rate / times), times * years);
        double finalAmount = getBalance() * factor;
        return finalAmount;

    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}

