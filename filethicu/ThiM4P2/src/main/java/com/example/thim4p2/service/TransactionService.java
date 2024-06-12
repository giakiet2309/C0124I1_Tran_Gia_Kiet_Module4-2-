package com.example.thim4p2.service;

import com.example.thim4p2.model.Transaction;
import com.example.thim4p2.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
