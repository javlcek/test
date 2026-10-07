package transfer;

import java.time.LocalDateTime;

public class Transaction {

    private String type;

    private String fromAccountNumber;

    private String toAccountNumber;

    private double amount;

    private double fee;

    private LocalDateTime timestamp;

    public Transaction(String type, String fromAccountNumber, String toAccountNumber, double amount, double fee, LocalDateTime timestamp) {
        this.type = type;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public double getFee() {
        return fee;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return type + " | from: " + fromAccountNumber + " | to: " + toAccountNumber
                + " | amount: " + amount + " | fee: " + fee + " | " + timestamp;
    }
}