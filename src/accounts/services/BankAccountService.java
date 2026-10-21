package accounts.services;

import accounts.BankAccount;
import accounts.factories.BankAccountFactory;
import person.AccountOwner;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService {

    private final BankAccountFactory bankAccountFactory = new BankAccountFactory();

    private final List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        var currentAccount = bankAccountFactory.createCurrentBankAccount(accountOwner, balance);
        bankAccounts.add(currentAccount);

        return currentAccount;
    }

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        var savingAccount = bankAccountFactory.createSavingBankAccount(accountOwner, balance);
        bankAccounts.add(savingAccount);

        return savingAccount;
    }

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        var studentAccount = bankAccountFactory.createStudentBankAccount(accountOwner, balance, school);
        bankAccounts.add(studentAccount);

        return studentAccount;
    }

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        var businessAccount = bankAccountFactory.createBusinessBankAccount(accountOwner, balance);
        bankAccounts.add(businessAccount);

        return businessAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
