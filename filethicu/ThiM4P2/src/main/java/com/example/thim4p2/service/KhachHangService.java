package com.example.thim4p2.service;

import com.example.thim4p2.model.KhachHang;
import com.example.thim4p2.model.Transaction;
import com.example.thim4p2.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    public List<KhachHang> getAllTransactions() {
        return khachHangRepository.findAll();
    }
}
