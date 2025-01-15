package com.jurma.tinybank.repository;

import com.jurma.tinybank.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    Account account = new Account();

    public double getBalance() {
        return account.getBalance();
    }

    public synchronized void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public synchronized void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
    }
}
