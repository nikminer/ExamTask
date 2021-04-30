package com.company.models;

public class Account extends AccountModel implements Transactable {

    public Account(AccountBuilder builder) {
        super(builder);
    }

    public float getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%010d:%s Amount: %.2f", id, this.getName(), this.getAmount());
    }

    @Override
    public void processTransaction(Transaction transaction) {
        this.transactions.add(transaction);

        if (transaction.from == this) {
            this.amount -= transaction.amount;
        }
        if (transaction.to == this) {
            this.amount += transaction.amount;
        }
    }
}
