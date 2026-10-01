package transfer;

import accounts.BankAccount;
import accounts.BusinessAccount;

public class AccountTransferService {

    private static final double BUSINESS_ACCOUNT_TRANSFER_FEE = 0.003;

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

        if (from instanceof BusinessAccount) {
            double transferFee = amount * BUSINESS_ACCOUNT_TRANSFER_FEE;

            total += transferFee;
        }

        if (from.getBalance() < total) {
            throw new IllegalArgumentException("nemas dost penez");
        }

        from.setBalance(from.getBalance() - total);
        to.setBalance(to.getBalance() + amount);
    }

}