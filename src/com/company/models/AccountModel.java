package com.company.models;

import com.company.models.base.BaseIdentification;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountModel extends BaseIdentification {
    static AtomicInteger lastId = new AtomicInteger(1);

    Person owner;

    float amount;

    String name;

    public ArrayList<Transaction> transactions;

    public AccountModel(AccountBuilder builder) {
        super(lastId.getAndIncrement());

        this.owner = builder.owner;

        this.name = builder.name;

        this.amount = builder.amount;

        this.transactions = new ArrayList<>();
    }

}
