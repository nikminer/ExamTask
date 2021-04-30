package com.company;

import com.company.models.*;
import com.company.models.PersonBuilder;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Person person1 = new PersonBuilder("John", "Doe").build();
        Person person2 = new PersonBuilder("Mike", "Smith").build();
        Person person3 = new PersonBuilder("Rintaro", "Okabe").build();

        int Max = new Random().nextInt(Bank.config.MaxRandomAccountOnPerson);
        if (Max < 2) {
            Max = 2;
        }

        for (int i = 0; i <= Max; i++) {
            person1.createAccount(person1.getName(), (float) new Random().nextInt(Bank.config.MaxRandomAccountMoney));
        }
        for (int i = 0; i <= Max; i++) {
            person2.createAccount(person2.getName(), (float) new Random().nextInt(Bank.config.MaxRandomAccountMoney));
        }

        for (int i = 0; i <= Max; i++) {
            person3.createAccount(person3.getName(), (float) new Random().nextInt(Bank.config.MaxRandomAccountMoney));
        }

        Bank.ChangeAccountName(person1.getAccountList().stream().findFirst().get(), "First JD Account");
        Bank.ChangeAccountName(person2.getAccountList().stream().findFirst().get(), "First MS Account");
        Bank.ChangeAccountName(person3.getAccountList().stream().findFirst().get(), "First OR Account");

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        List<Future> futures = new ArrayList<>();

        List<Account> accountList = new ArrayList<>();
        accountList.addAll(person1.getAccountList());
        accountList.addAll(person2.getAccountList());
        accountList.addAll(person3.getAccountList());
        Collections.shuffle(accountList);
        long count = accountList.stream().count();
        for (int i = 0; i < Bank.config.CountGenaratingTransaction; i++) {
            int amount = new Random().nextInt(Bank.config.MaxRandomAmountTransaction);
            Account account1, account2;
            account1 = accountList.get(new Random().nextInt((int) count));
            account2 = accountList.get(new Random().nextInt((int) count));
            futures.add(Bank.SendMoney(account1, account2, amount));
        }


        for (Future future : futures) {
            future.get();
        }

        for (Transaction trans : Bank.transactionMap.values()) {
            System.out.println(trans);
        }

        for (Transaction trans : Bank.transactionMap.values()) {
            System.out.println(trans.getSpeedStr());
        }

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        Bank.service.shutdown();
    }
}
