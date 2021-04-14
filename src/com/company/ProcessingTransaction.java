package com.company;

import com.company.models.Transaction;

import java.util.concurrent.Semaphore;

public class ProcessingTransaction implements Runnable{
    final Transaction trans;

    ProcessingTransaction (Transaction trans)
    {
        this.trans = trans;
    }

    @Override
    public void run()
    {
        if (trans.getFrom().getAmount() >= trans.getAmount())
        {
            trans.setTransStatus(TransStatus.Success);
            trans.getFrom().processTransaction(trans);
            trans.getTo().processTransaction(trans);
        }
        else
        {
            trans.setTransStatus(TransStatus.NotEnoughMoney);
        }
    }

}
