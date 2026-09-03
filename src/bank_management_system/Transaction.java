package bank_management_system;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final String transactionId;
    private final TransactionType type;
    private final BigDecimal amount;
    private final BigDecimal balanceAfterTransaction;
    private final LocalDateTime dateTime;

    public Transaction(String transactionId,TransactionType type,BigDecimal amount,BigDecimal balanceAfterTransaction) {

        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.dateTime = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format(
                "%-12s %-12s ₹%-12.2f ₹%-15.2f %s",
                transactionId,
                type,
                amount,
                balanceAfterTransaction,
                dateTime.format(formatter)
        );
    }
}
