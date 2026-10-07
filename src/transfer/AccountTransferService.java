package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.StudentAccount;

public class AccountTransferService {

    private static final double BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003;

    private TransferLoggerService transferLoggerService;

    public AccountTransferService(TransferLoggerService transferLoggerService) {
        this.transferLoggerService = transferLoggerService;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("ucet nesmi byt null");
        }

        if (from == to) {
            throw new IllegalArgumentException("nemuzes poslat penize sam sobe");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("castka musi byt kladna");
        }

        double total = amount;
        double fee = 0;

        if (from instanceof BusinessAccount) {
            double transferFee = amount * BUSINESS_ACCOUNT_TRANSFER_FEE;

            fee = transferFee;
            total += transferFee;
        }

        if ((from.getBalance() - total) < getTransferLimit(from)) {
            throw new IllegalArgumentException("nemas dost penez");
        }

        from.setBalance(from.getBalance() - total);
        to.setBalance(to.getBalance() + amount);

        transferLoggerService.logTransfer(from, to, amount, fee);
    }

    private int getTransferLimit(BankAccount account) {
        if (account instanceof StudentAccount) {
            return -5000;
        }

        return 0;
    }

}
