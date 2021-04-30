package com.company.models;

import com.company.TransStatus;

import java.time.Duration;
import java.time.LocalDateTime;

public class Transaction extends TransactionModel {
    public Transaction(Account from, Account to, double amount) {
        super(from, to, amount);
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public void setTransStatus(TransStatus transStatus) {
        if (this.transStatus == null) {
            this.transStatus = transStatus;
            this.completeTrans = LocalDateTime.now();
        }
    }

    public String getSpeedStr() {
        return String.format(
                "%d %s -> %s %sms",
                id,
                from.name,
                to.name,
                Duration.between(creationDateTime, completeTrans).toMillis()
        );
    }

    @Override
    public String toString() {
        return String.format(
                "%tD: %s -> %s %.2f %s",
                creationDateTime,
                from.name,
                to.name,
                amount,
                transStatus
        );
    }
}
