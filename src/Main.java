import accounts.BankAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import accounts.serialization.BankAccountGsonSerializer;
import accounts.serialization.BankAccountSerializer;
import accounts.serialization.BankAccountXmlSerializer;
import accounts.services.BankAccountService;
import person.AccountOwner;
import person.services.AccountOwnerService;
import transfer.DepositTransferService;
import transfer.WithdrawTransferService;

void main() {

    var accountOwnerService = new AccountOwnerService();
    var bankAccountService = new BankAccountService();

    AccountOwner accountOwner = accountOwnerService.createAccountOwner("Tomas", "Pesek");

    var bankAccount = bankAccountService.createCurrentBankAccount(accountOwner, 500);
    bankAccountService.createStudentBankAccount(accountOwner, 500, "Delta");
    bankAccountService.createSavingBankAccount(accountOwner, 500);
    bankAccountService.createBusinessBankAccount(accountOwner, 500);

    BankAccountSerializer bankAccountJsonSerializer = new BankAccountGsonSerializer();
    BankAccountSerializer bankAccountXmlSerializer = new BankAccountXmlSerializer();

    String bankAccountXml = bankAccountXmlSerializer.serialize(bankAccount);
    String bankAccountXmlAll = bankAccountXmlSerializer.serializeAll(bankAccountService.getBankAccounts());

    String bankAccountJson = bankAccountJsonSerializer.serialize(bankAccount);
    String bankAccountJsonAll = bankAccountJsonSerializer.serializeAll(bankAccountService.getBankAccounts());

    IO.println(bankAccountXml);
    IO.println(bankAccountXmlAll);

    IO.println(bankAccountJson);
    IO.println(bankAccountJsonAll);

    for (var account : bankAccountService.getBankAccounts()) {
        if (account instanceof InterestPoint interestPoint) {
            interestPoint.calculateInterest();
        }
    }

    for (var account : bankAccountService.getBankAccounts()) {
        if (account instanceof StudentAccount studentAccount) {
            IO.println("school: " + studentAccount.getSchoolName());
        }

        IO.println("balance: " + account.getBalance());
    }

    printBalance(bankAccount);

    var depositTransferService = new DepositTransferService();
    depositTransferService.deposit(bankAccount, 400);
    depositTransferService.deposit(bankAccount, 100);
    depositTransferService.deposit(bankAccount, 200);
    depositTransferService.deposit(bankAccount, 600);

    printBalance(bankAccount);

    var withdrawTransferService = new WithdrawTransferService();

    withdrawTransferService.withdraw(bankAccount, 300);
    withdrawTransferService.withdraw(bankAccount, 300);

    withdrawTransferService.withdraw(bankAccount, 100);
    withdrawTransferService.withdraw(bankAccount, 50);
    withdrawTransferService.withdraw(bankAccount, 400);

    printBalance(bankAccount);
}

private void printBalance(BankAccount bankAccount) {
    IO.println("balance: " + bankAccount.getBalance());
}
