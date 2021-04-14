package com.company;

import com.company.models.*;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Person person = new PersonBuilder("John", "Doe").build();
        List<Account> accountList = person.getAccountList();
        accountList.add(new AccountBuilder(person).name("JDaccount1").amount(25000).build());
        System.out.println(person);


        Person person1 = new PersonBuilder("John", "Smith").build();
        List<Account> accountList1 = person1.getAccountList();
        accountList1.add(new AccountBuilder(person1).name("JSaccount1").amount(3000).build());
        System.out.println(person1);

        List<Future> futures = new ArrayList<>();

        futures.add(Bank.SendMoney(accountList.get(0), accountList1.get(0), 3000.2));
        futures.add(Bank.SendMoney(accountList.get(0), accountList1.get(0), 5000.5));
        futures.add(Bank.SendMoney(accountList1.get(0), accountList.get(0), 2000.5));
        futures.add(Bank.SendMoney(accountList1.get(0), accountList.get(0), 500000));

        Bank.ChangeAccountName(accountList1.get(0), "John Smith Account");
        Bank.ChangeAccountName(accountList.get(0), "John Doe Account");

        for (Future future:futures) {
            future.get();
        }

        for (Transaction trans:Bank.transactionMap.values()) {
            System.out.println(trans);
        }



        System.out.println(person);
        System.out.println(person1);

        Bank.service.shutdown();
    }
}
