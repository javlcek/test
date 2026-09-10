package accounts;

import person.AccountOwner;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
        setAccountType("Savings");
    }

    public SavingsAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
        setAccountType("Savings");
    }

    @Override
    public void add(double amount) {
        super.add(amount * 1.005);
    }

}
