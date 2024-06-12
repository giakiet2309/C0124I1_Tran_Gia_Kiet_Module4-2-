package com.example.thim4p2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@Table(name = "giao_dich")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_giao_dich")
    private String maGiaoDich; // Mã giao dịch dạng "MGV-XXXX"
    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang maKhachHang;

    @Column(name = "ngay_giao_dich")
    private LocalDate ngayGiaoDich;

    @Column(name = "loai_dich_vu")
    private String loaiDichVu;

    @Column(name = "don_gia")
    private double donGia; // Sử dụng BigDecimal cho tiền đơn giá

    @Column(name = "dien_tich")
    private Double dienTich;

    // Constructors, getters, setters...
}

