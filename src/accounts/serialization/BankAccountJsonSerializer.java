package accounts.serialization;

import accounts.BankAccount;

import java.util.List;
import java.util.stream.Collectors;

public class BankAccountJsonSerializer implements BankAccountSerializer {

    private static final String ACCOUNT_TEMPLATE = """
            {"accountNumber": "%s"}""";

    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serialize(BankAccount bankAccount) {
        var serialized = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        return ACCOUNT_TEMPLATE.formatted(serialized.accountNumber());
    }

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        return bankAccounts.stream()
                .map(this::serialize)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
