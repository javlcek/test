import accounts.*;
import person.AccountOwner;
import transfer.AccountTransferService;
import transfer.DepositTransferService;
import transfer.WithdrawTransferService;

import java.util.ArrayList;
import java.util.List;

void main() {

    AccountOwner accountOwner = new AccountOwner("Tomas", "Pesek");
    accountOwner.setLastName("Pokorny");

    BankAccount bankAccount = new CurrentAccount(accountOwner, "123", 500);
    BankAccount studentAccount = new StudentAccount(accountOwner, "123", 500, "Delta");
    BankAccount savingAccount = new SavingAccount(accountOwner, "123");

    List<BankAccount> bankAccounts = new ArrayList<>();
    bankAccounts.add(bankAccount);
    bankAccounts.add(studentAccount);

    for (BankAccount account : bankAccounts) {
        if (account instanceof InterestPoint) {
            ((InterestPoint) account).calculateInterest();
        }
    }

    for (BankAccount account : bankAccounts) {

        if (account instanceof StudentAccount) {
            StudentAccount stdAccount = (StudentAccount) account;
            IO.println("school: " + stdAccount.getSchoolName());
        }

        IO.println("balance: " + account.getBalance());

    }

    printBalance(bankAccount);

    DepositTransferService depositTransferService = new DepositTransferService();
    depositTransferService.deposit(bankAccount, 400);
    depositTransferService.deposit(bankAccount, 100);
    depositTransferService.deposit(bankAccount, 200);
    depositTransferService.deposit(bankAccount, 600);

    printBalance(bankAccount);

    WithdrawTransferService withdrawTransferService = new WithdrawTransferService();

    withdrawTransferService.withdraw(bankAccount, 300);
    withdrawTransferService.withdraw(bankAccount, 300);

    withdrawTransferService.withdraw(bankAccount, 100);
    withdrawTransferService.withdraw(bankAccount, 50);
    withdrawTransferService.withdraw(bankAccount, 400);

    printBalance(bankAccount);

    AccountTransferService accountTransferService = new AccountTransferService();

    BusinessAccount businessAccount = new BusinessAccount(accountOwner, "999");
    businessAccount.setBalance(1000);

    IO.println("-- account to account transfer --");

    accountTransferService.transfer(bankAccount, studentAccount, 200);
    printAccountBalance(bankAccount, studentAccount);

    accountTransferService.transfer(businessAccount, studentAccount, 300);
    printAccountBalance(businessAccount, studentAccount);

    try {
        accountTransferService.transfer(bankAccount, studentAccount, -100);
    } catch (IllegalArgumentException e) {
        IO.println("chyba: " + e.getMessage());
    }

    try {
        accountTransferService.transfer(bankAccount, bankAccount, 100);
    } catch (IllegalArgumentException e) {
        IO.println("chyba: " + e.getMessage());
    }

    try {
        accountTransferService.transfer(bankAccount, studentAccount, 100000);
    } catch (IllegalArgumentException e) {
        IO.println("chyba: " + e.getMessage());
    }
}

private void printAccountBalance(BankAccount from, BankAccount to) {
    IO.println("from: " + from.getBalance() + ", to: " + to.getBalance());
}

private void printBalance(BankAccount bankAccount) {
    IO.println("balance: " + bankAccount.getBalance());
}