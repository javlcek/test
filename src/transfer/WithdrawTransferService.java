package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;

public class WithdrawTransferService {
    public void withdraw(BankAccount bankAccount, double amount){
        double newBalance = bankAccount.getBalance() - amount;

        private static final double BUSINESS_ACCOUNT_SERVICE_FEE = 0.01;

        if (bankAccount instanceof BusinessAccount) {
            double serviceFee = amount * BUSINESS_ACCOUNT_SERVICE_FEE;
        }
    }
}
