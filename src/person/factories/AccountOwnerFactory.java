package person.factories;

import person.AccountOwner;

import java.util.UUID;

public class AccountOwnerFactory {

    public AccountOwner createAccountOwner(String name, String lastName) {
        var uuid = UUID.randomUUID().toString();

        return new AccountOwner(uuid, name, lastName);
    }

}
