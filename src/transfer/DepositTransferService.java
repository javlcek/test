package transfer;

import accounts.BankAccount;
import accounts.StudentAccount;

public class DepositTransferService {

    private static final double STUDENT_ACCOUNT_DEPOSIT_BONUS = 0.005;

    private TransferLoggerService transferLoggerService;

    public DepositTransferService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void deposit(BankAccount bankAccount, double amount) {
        double newBalance = bankAccount.getBalance() + amount;

        double fee = 0;

        if (bankAccount instanceof StudentAccount) {
            double depositBonus = amount * STUDENT_ACCOUNT_DEPOSIT_BONUS;

            fee = depositBonus;
            newBalance += depositBonus;
        }

        bankAccount.setBalance(newBalance);

        transferLoggerService.logDeposit(bankAccount, amount, fee);
    }

}