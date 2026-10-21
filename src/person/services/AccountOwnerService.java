package person.services;

import person.AccountOwner;
import person.factories.AccountOwnerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountOwnerService {

    private final AccountOwnerFactory accountOwnerFactory = new AccountOwnerFactory();

    private final List<AccountOwner> accountOwners = new ArrayList<>();

    public AccountOwner createAccountOwner(String name, String lastName) {
        var owner = accountOwnerFactory.createAccountOwner(name, lastName);

        accountOwners.add(owner);

        return owner;
    }

    public List<AccountOwner> getAccountOwners() {
        return accountOwners;
    }

}
