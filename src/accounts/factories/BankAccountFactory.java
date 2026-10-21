package accounts.factories;

import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.CurrentAccount;
import accounts.SavingAccount;
import accounts.StudentAccount;
import accounts.services.AccountNumberGenerator;
import person.AccountOwner;

import java.util.UUID;

public class BankAccountFactory {

    private final AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator("0800");

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        return initBankAccount(new CurrentAccount(accountOwner, balance));
    }

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        return initBankAccount(new SavingAccount(accountOwner, balance));
    }

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        return initBankAccount(new StudentAccount(accountOwner, balance, school));
    }

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        return initBankAccount(new BusinessAccount(accountOwner, balance));
    }

    private BankAccount initBankAccount(BankAccount bankAccount) {
        bankAccount.setUuid(UUID.randomUUID().toString());
        bankAccount.setAccountNumber(accountNumberGenerator.generate());

        return bankAccount;
    }
}
