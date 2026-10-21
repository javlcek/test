package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public interface BankAccountSerializer {

    String serialize(BankAccount bankAccount);

    String serializeAll(List<BankAccount> bankAccounts);

}
