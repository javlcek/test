package accounts;

import person.AccountOwner;

import java.util.UUID;

public class BankAccountFactory {

    public CurrentAccount createCurrentAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        return new CurrentAccount(UUID.randomUUID().toString(), accountOwner, accountNumber, balance);
    }

    public StudentAccount createStudentAccount(AccountOwner accountOwner, String accountNumber, double balance, String schoolName) {
        return new StudentAccount(UUID.randomUUID().toString(), accountOwner, accountNumber, balance, schoolName);
    }

    public SavingAccount createSavingAccount(AccountOwner accountOwner, String accountNumber) {
        return new SavingAccount(UUID.randomUUID().toString(), accountOwner, accountNumber);
    }

    public BusinessAccount createBusinessAccount(AccountOwner accountOwner, String accountNumber) {
        return new BusinessAccount(UUID.randomUUID().toString(), accountOwner, accountNumber);
    }

}
