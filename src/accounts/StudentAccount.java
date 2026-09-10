package accounts;

import person.AccountOwner;

public class StudentAccount extends BankAccount {
    private String schoolName;

    public StudentAccount(AccountOwner accountOwner, String accountNumber){
        super(accountOwner, accountNumber);
        setAccountType("Student");
    }

    public StudentAccount(AccountOwner accountOwner, String accountNumber, double balance, String schoolName){
        super(accountOwner, accountNumber, balance);
        this.schoolName = schoolName;
        setAccountType("Student");
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    protected double getOverdraftLimit() {
        return 5000;
    }

}
