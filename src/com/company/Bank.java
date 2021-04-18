package com.company;

import com.company.models.Account;
import com.company.models.Transaction;

import java.util.TreeMap;
import java.util.concurrent.*;

public class Bank
{
    static TreeMap<Integer, Transaction> transactionMap = new TreeMap();

    public synchronized static void AddTransaction(Transaction transaction)
    {
        transactionMap.put(transaction.getId(), transaction);
    }

    public static Transaction FindTransaction(int id)
    {
        return transactionMap.get(id);
    }

    static ExecutorService service = Executors.newFixedThreadPool(3);


    public static Future SendMoney(Account from, Account to, double amount) throws InterruptedException {
        Runnable worker;
        Transaction transaction = new Transaction(from, to, amount);
        Thread.sleep(20);
        Bank.AddTransaction(transaction);
        worker = new ProcessingTransaction(transaction);

        return service.submit(worker);
    }

    public static void ChangeAccountName(Account account, String newName) throws ExecutionException, InterruptedException {
        Runnable worker = () -> {
            account.setName(newName);
        };

        service.submit(worker).get();
    }

}
