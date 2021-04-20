package com.company.models;

import java.util.List;

public class Person extends PersonModel
{
    public Person(PersonBuilder builder)
    {
        super(builder);
    }

    public List<Account> getAccountList()
    {
        return accountList;
    }

    @Override
    public String toString() {
        String str = String.format("%s %s\n", firstName, lastName);

        for (Account acc:this.getAccountList())
        {
           str += acc + "\n";
        }

        return str;
    }

    public String getName()
    {
        return this.firstName + " " + this.lastName;
    }

    public Account createAccount(String name, float amount)
    {
        Account acc = new AccountBuilder(this).name(name).amount(amount).build();
        this.accountList.add(acc);

        return acc;
    }

}