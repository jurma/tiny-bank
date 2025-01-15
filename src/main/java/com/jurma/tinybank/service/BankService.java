package com.jurma.tinybank.service;

import com.jurma.tinybank.model.Transaction;
import com.jurma.tinybank.repository.AccountRepository;
import com.jurma.tinybank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jurma.tinybank.model.TransactionType.DEPOSIT;
import static com.jurma.tinybank.model.TransactionType.WITHDRAW;

@Service
@RequiredArgsConstructor
public class BankService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public double deposit(double amount) {
        accountRepository.deposit(amount);
        transactionRepository.add(new Transaction(DEPOSIT, amount));
        return accountRepository.getBalance();
    }

    public double withdraw(double amount) {
        double balance = accountRepository.getBalance();
        if (balance >= amount) {
            accountRepository.withdraw(amount);
            transactionRepository.add(new Transaction(WITHDRAW, amount));
        } else {
            throw new RuntimeException("Insufficient funds: " + balance);
        }
        return accountRepository.getBalance();
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }

    public double getBalance() {
        return accountRepository.getBalance();
    }
}
