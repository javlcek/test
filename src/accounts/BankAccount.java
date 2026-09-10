package accounts;
import person.AccountOwner;

import java.util.UUID;

public abstract class BankAccount {

    private String accountType;
    private String uuid;

    private AccountOwner accountOwner;

    private String accountNumber;

    private double balance;

    public BankAccount(AccountOwner accountOwner, String accountNumber) {
        this.uuid = UUID.randomUUID().toString();
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public BankAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        this.uuid = UUID.randomUUID().toString();
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    protected void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    protected double getOverdraftLimit() {
        return 0;
    }

    public void changeBalance(double amount){
        this.balance += amount;
    }

    public void add(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("nemuze byt negativni");
        }

        this.balance += amount;
    }

    public void sub(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("nemuze byt negativni");
        }

        double newBalance = balance - amount;

        if (newBalance < -getOverdraftLimit()){
            throw new IllegalArgumentException("nedostatek penez");
        }

        this.balance = newBalance;
    }

}