package com.company.models;

import com.company.TransStatus;
import com.company.models.base.BaseIdentification;

import java.util.concurrent.atomic.AtomicInteger;

public class Transaction extends BaseIdentification
{
    static AtomicInteger lastId = new AtomicInteger(1);

    final Account from;
    final Account to;

    TransStatus transStatus;
    final double amount;

    public Transaction (Account from, Account to , double amount)
    {
        super(lastId.getAndIncrement());

        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public Account getFrom()
    {
        return from;
    }

    public Account getTo()
    {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public void setTransStatus(TransStatus transStatus) {
        if (this.transStatus == null)
        {
            this.transStatus = transStatus;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%tD: %s -> %s %.2f %s", creationDateTime, from.name, to.name, amount, transStatus);
    }

}
