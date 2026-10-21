package accounts;

// 2010

import notifier.ConsoleNotifierService;
import notifier.NotifierService;
import person.AccountOwner;

// 2102405518
public abstract class BankAccount {

    private String uuid;

    private final AccountOwner accountOwner;

    private String accountNumber;

    private double balance;

    private final NotifierService notifierService = new ConsoleNotifierService();

    protected BankAccount(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
        this.balance = 0;
    }

    protected BankAccount(AccountOwner accountOwner, double balance) {
        this(accountOwner);

        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
