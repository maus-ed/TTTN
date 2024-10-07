package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "chu_de")
public class ChuDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "trang_thai_the_loai")
    private Integer trangThaiTheLoai;

    @Column(name = "ma")
    private String ma;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "ten")
    private String ten;

    @Column(name = "tien_ban_quyen")
    private BigDecimal tienBanQuyen;

    // Getters and Setters
}

