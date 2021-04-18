package com.company.models;

public class AccountBuilder
{
    float amount = 0;
    Person owner;
    String name;

    public AccountBuilder(Person owner)
    {
        this.owner = owner;
    }

    public AccountBuilder amount(float val)
    {
        this.amount = val;
        return this;
    }

    public AccountBuilder name(String val)
    {
        this.name = val;
        return this;
    }

    public Account build()
    {
        if (name == null)
        {
            this.name = String.format("Account of %s %s", owner.firstName, owner.lastName);
        }

        return new Account(this);
    }
}
