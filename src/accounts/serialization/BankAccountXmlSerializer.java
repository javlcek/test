package accounts.serialization;

import accounts.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class BankAccountXmlSerializer implements BankAccountSerializer {

    private final XmlMapper xmlMapper = new XmlMapper();

    private final BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serialize(BankAccount bankAccount) {
        return write(toSerialize(bankAccount), "bankAccount");
    }

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        var serialized = new BankAccountList(bankAccounts.stream()
                .map(this::toSerialize)
                .toList());

        return write(serialized, "root");
    }

    private BankAccountSerialize toSerialize(BankAccount bankAccount) {
        return bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);
    }

    private String write(Object value, String rootName) {
        try {
            return xmlMapper.writer()
                    .withRootName(rootName)
                    .writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private record BankAccountList(
            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "bankAccount")
            List<BankAccountSerialize> accounts) {
    }
}
