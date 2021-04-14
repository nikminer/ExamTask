package com.company.models;

import com.company.*;
import com.company.models.base.BaseIdentification;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Account extends BaseIdentification
{
    static AtomicInteger lastId = new AtomicInteger(1);

    Person owner;

    float amount;

    String name;

    ArrayList<Transaction> transactions;

    public Account (AccountBuilder builder)
    {
        super(lastId.getAndIncrement());

        this.owner = builder.owner;

        this.name = builder.name;

        this.amount = builder.amount;

        this.transactions = new ArrayList<>();
    }

    public float getAmount()
    {
        return amount;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("%010d:%s Amount: %.2f", id, name, amount);
    }

    public void processTransaction(Transaction transaction)
    {
        if (transaction.from == this)
        {
            this.amount -= transaction.amount;
        }
        if (transaction.to == this)
        {
            this.amount += transaction.amount;
        }

        this.transactions.add(transaction);
    }
}
