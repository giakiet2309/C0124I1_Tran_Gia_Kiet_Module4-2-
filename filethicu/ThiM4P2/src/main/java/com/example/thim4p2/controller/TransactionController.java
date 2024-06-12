package com.example.thim4p2.controller;

import com.example.thim4p2.model.KhachHang;
import com.example.thim4p2.model.Transaction;
import com.example.thim4p2.service.KhachHangService;
import com.example.thim4p2.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transaction-list";
    }

    @GetMapping("/add")
    public String showAddTransactionForm(Model model) {
        List<KhachHang> listKhachHang = khachHangService.getAllTransactions();
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("transaction", new Transaction());
        return "add-transaction";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute("transaction") @Valid Transaction transaction, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<KhachHang> listKhachHang = khachHangService.getAllTransactions();
            model.addAttribute("listKhachHang", listKhachHang);
            return "add-transaction";
        }
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }
    @GetMapping("/details/{id}")
    public String getTransactionDetails(@PathVariable Long id, Model model) {
        Optional<Transaction> optionalTransaction = transactionService.getTransactionById(id);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            model.addAttribute("transaction", transaction);
        }
        return "transaction-details";
    }
    @PostMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }

}