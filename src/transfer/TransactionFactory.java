package transfer;

import accounts.BankAccount;

import java.time.LocalDateTime;

public class TransactionFactory {

    public Transaction createDepositTransaction(BankAccount bankAccount, double amount, double fee) {
        return new Transaction("DEPOSIT", null, bankAccount.getAccountNumber(), amount, fee, LocalDateTime.now());
    }

    public Transaction createWithdrawTransaction(BankAccount bankAccount, double amount, double fee) {
        return new Transaction("WITHDRAW", bankAccount.getAccountNumber(), null, amount, fee, LocalDateTime.now());
    }

    public Transaction createTransferTransaction(BankAccount from, BankAccount to, double amount, double fee) {
        return new Transaction("TRANSFER", from.getAccountNumber(), to.getAccountNumber(), amount, fee, LocalDateTime.now());
    }
}