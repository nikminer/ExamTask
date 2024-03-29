package com.company.models;

import com.company.models.base.BaseIdentification;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PersonModel extends BaseIdentification {

    static AtomicInteger lastId = new AtomicInteger(1);

    String firstName;
    String lastName;
    List<Account> accountList;

    public PersonModel(PersonBuilder builder) {
        super(lastId.getAndIncrement());
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.accountList = builder.accountList;
    }
}
