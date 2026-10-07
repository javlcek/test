package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.StudentAccount;

public class WithdrawTransferService {

    private static final double BUSINESS_ACCOUNT_SERVICE_FEE = 0.01;

    private TransferLoggerService transferLoggerService;

    public WithdrawTransferService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void withdraw(BankAccount account, double amount) {
        double newBalance = account.getBalance() - amount;

        double fee = 0;

        if (account instanceof BusinessAccount) {
            double serviceFee = amount * BUSINESS_ACCOUNT_SERVICE_FEE;

            fee = serviceFee;
            newBalance -= serviceFee;
        }

        if (newBalance < getWithDrawLimit(account)) {
            throw new IllegalArgumentException("nedostatek penez");
        }

        account.setBalance(newBalance);

        transferLoggerService.logWithdraw(account, amount, fee);
    }

    private int getWithDrawLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return -5000;
        }

        return 0;
    }

}