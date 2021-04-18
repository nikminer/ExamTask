package com.company;

import com.company.models.*;
import com.company.models.PersonBuilder;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Account account1, account2;

        Person person1 = new PersonBuilder("John", "Doe").build();
        account1 = person1.createAccount("JDaccount1", (float) new Random().nextInt(Bank.config.MaxRandomAccountMoney));
        System.out.println(person1);

        Person person2 = new PersonBuilder("John", "Smith").build();
        account2 = person2.createAccount("JSaccount1", (float) new Random().nextInt(Bank.config.MaxRandomAccountMoney));
        System.out.println(person2);

        List<Future> futures = new ArrayList<>();

        futures.add(Bank.SendMoney(account1, account2, 3000.2));
        futures.add(Bank.SendMoney(account1, account2, 5000.5));
        futures.add(Bank.SendMoney(account2, account1, 2000.5));
        futures.add(Bank.SendMoney(account2, account1, 500000));

        Bank.ChangeAccountName(account2, "John Smith Account");
        Bank.ChangeAccountName(account1, "John Doe Account");

        for (Future future:futures) {
            future.get();
        }

        for (Transaction trans:Bank.transactionMap.values()) {
            System.out.println(trans);
        }

        System.out.println(person1);
        System.out.println(person2);

        Bank.service.shutdown();
    }
}
