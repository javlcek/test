package transfer;

import accounts.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private TransactionFactory transactionFactory = new TransactionFactory();

    private List<Transaction> transactions = new ArrayList<>();

    public void logDeposit(BankAccount bankAccount, double amount, double fee) {
        transactions.add(transactionFactory.createDepositTransaction(bankAccount, amount, fee));
    }

    public void logWithdraw(BankAccount bankAccount, double amount, double fee) {
        transactions.add(transactionFactory.createWithdrawTransaction(bankAccount, amount, fee));
    }

    public void logTransfer(BankAccount from, BankAccount to, double amount, double fee) {
        transactions.add(transactionFactory.createTransferTransaction(from, to, amount, fee));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}