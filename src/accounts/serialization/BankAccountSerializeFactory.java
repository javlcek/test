package accounts.serialization;

import accounts.BankAccount;

public class BankAccountSerializeFactory {

    public BankAccountSerialize createBankAccountSerialize(BankAccount bankAccount) {
        return new BankAccountSerialize(bankAccount.getAccountNumber());
    }

}
