package accounts;

import person.AccountOwner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(String uuid, AccountOwner accountOwner, String accountNumber) {
        super(uuid, accountOwner, accountNumber);
    }

}