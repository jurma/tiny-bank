package com.jurma.tinybank.controller;

import com.jurma.tinybank.model.Transaction;
import com.jurma.tinybank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService service;

    @PostMapping("/deposit")
    public double deposit(@RequestParam double amount) {
        return service.deposit(amount);
    }

    @PostMapping("/withdraw")
    public double withdraw(@RequestParam double amount) {
        return service.withdraw(amount);
    }

    @GetMapping("/balance")
    public double getBalance() {
        return service.getBalance();
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return service.getTransactions();
    }
}