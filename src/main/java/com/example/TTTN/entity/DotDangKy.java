package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "dot_dang_ky")
public class DotDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "ngay_bat_dau_dk")
    private Date ngayBatDauDk;

    @Column(name = "ngay_ket_thuc_dk")
    private Date ngayKetThucDk;

    @Column(name = "trang_thai")
    private int trangThai;
}
