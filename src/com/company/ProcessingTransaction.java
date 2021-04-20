package com.company;

import com.company.models.Transaction;

public class ProcessingTransaction implements Runnable {
    final Transaction trans;

    static Object sync = new Object();

    ProcessingTransaction (Transaction trans)
    {
        this.trans = trans;
    }

    @Override
    public void run() {
        synchronized (sync)
        {
            if (trans.getFrom().getAmount() >= trans.getAmount()) {
                trans.setTransStatus(TransStatus.Success);
                trans.getFrom().processTransaction(trans);
                trans.getTo().processTransaction(trans);
            } else {
                trans.setTransStatus(TransStatus.NotEnoughMoney);
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
