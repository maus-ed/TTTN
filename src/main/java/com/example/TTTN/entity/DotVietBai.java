package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "dot_viet_bai")
public class DotVietBai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "dot_dang_ky_id")
    private DotDangKy dotDangKy;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "so_bai_da_phan")
    private int soBaiDaPhan;

    @Column(name = "so_nguoi_phan_cong")
    private int soNguoiPhanCong;

}
