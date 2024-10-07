package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "binh_luan")
public class BinhLuan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @ManyToOne
    @JoinColumn(name = "bai_viet_id")
    private BaiViet baiViet;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "tra_loi")
    private String traLoi;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    // Getters and Setters
}

