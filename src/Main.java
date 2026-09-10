import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.CurrentAccount;
import accounts.SavingsAccount;
import accounts.StudentAccount;
import person.AccountOwner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    AccountOwner accountOwner = new AccountOwner("Tomas", "Pesek");
    accountOwner.setLastName("Pokorny");

    BankAccount current = new CurrentAccount(accountOwner, "123", 1000);
    current.sub(600);
    withdraw(current, 500);

    StudentAccount student = new StudentAccount(accountOwner, "456", 0, "CVUT");
    student.sub(5000);
    withdraw(student, 1);

    SavingsAccount savings = new SavingsAccount(accountOwner, "789", 0);
    savings.add(10000);

    BusinessAccount business = new BusinessAccount(accountOwner, "999", 1000);
    business.sub(100);
}

void withdraw(BankAccount account, double amount) {
    try {
        account.sub(amount);
    } catch (IllegalArgumentException e) {
        IO.println("chyba");
    }
}
