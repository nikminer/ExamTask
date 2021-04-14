package com.company.models;

import com.company.models.base.BaseIdentification;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Person extends BaseIdentification
{
    static AtomicInteger lastId = new AtomicInteger(1);

    String firstName;
    String lastName;
    List<Account> accountList;

    public Person(PersonBuilder builder)
    {
        super(lastId.getAndIncrement());
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.accountList = builder.accountList;
    }

    public List<Account> getAccountList()
    {
        return accountList;
    }

    @Override
    public String toString() {
        String str = String.format("%s %s\n", firstName, lastName);

        for (Account acc:accountList)
        {
           str += acc + "\n";
        }

        return str;
    }
}
