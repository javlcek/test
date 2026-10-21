package accounts.serialization;

import accounts.BankAccount;
import com.google.gson.Gson;

import java.util.List;

public class BankAccountGsonSerializer implements BankAccountSerializer {

    private final Gson gson = new Gson();

    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serialize(BankAccount bankAccount) {
        return gson.toJson(bankAccountSerializeFactory.createBankAccountSerialize(bankAccount));
    }

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        var serialized = bankAccounts.stream()
                .map(bankAccountSerializeFactory::createBankAccountSerialize)
                .toList();

        return gson.toJson(serialized);
    }
}
