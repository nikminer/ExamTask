package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class PersonBuilder {
    String firstName;
    String lastName;
    List<Account> accountList;

    public PersonBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonBuilder AccountList(List<Account> val) {
        this.accountList = val;
        return this;
    }

    public Person build() {
        if (accountList == null) {
            accountList = new ArrayList<Account>();
        }

        Person newPerson = new Person(this);

        return newPerson;
    }

}
