package com.driver;

import java.util.Random;

public class BankAccount {
    private String name;
    private double balance;
    private double minBalance;




    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if (digits <= 0) {
            throw new Exception("Account Number can not be generated");
        }

        if (sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            int digit = Math.min(9, sum);
            accountNumber.append(digit);
            sum -= digit;
        }
        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
            this.balance += amount;
//        System.out.println(this.balance);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance < amount){
            throw new RuntimeException("Insufficient Balance");
        }else if (amount < this.balance ){
            this.balance -= amount;
        }
        if(this.balance < this.minBalance){
            throw new RuntimeException("Insufficient Balance");
        }
    }


    // getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }


}