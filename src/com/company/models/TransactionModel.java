package com.company.models;

import com.company.TransStatus;
import com.company.models.base.BaseIdentification;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionModel extends BaseIdentification {
    static AtomicInteger lastId = new AtomicInteger(1);

    final Account from;
    final Account to;

    TransStatus transStatus;
    LocalDateTime completeTrans;

    final double amount;

    public TransactionModel(Account from, Account to , double amount)
    {
        super(lastId.getAndIncrement());
        this.amount = amount;
        this.from = from;
        this.to = to;
    }
}
