package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "danh_gia")
public class DanhGia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "content")
    private String content;

    @Column(name = "star")
    private Integer star;

    @ManyToOne
    @JoinColumn(name = "bai_viet_id")
    private BaiViet baiViet;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    // Getters and Setters
}

