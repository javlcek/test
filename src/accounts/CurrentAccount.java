package accounts;

import person.AccountOwner;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
        setAccountType("Current");
    }

    public CurrentAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        super(accountOwner, accountNumber, balance);
        setAccountType("Current");
    }
}
