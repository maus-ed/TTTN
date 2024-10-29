package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "gui_bieu_mau")
public class GuiBieuMau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ma_nguoi_dung")
    private Integer maNguoiDung;

    @Column(name = "co_hoat_dong")
    private Integer coHoatDong;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "url")
    private String url;

    // Getters and Setters
}

