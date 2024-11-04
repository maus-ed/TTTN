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
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "tu_ngay")
    private Date tuNgay;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_luong_bai_viet")
    private Integer soLuongBaiViet;

    @ManyToOne
    @JoinColumn(name = "dot_dang_ky_id")
    private DotDangKy dotDangKy;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "den_ngay")
    private Date denNgay;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;

    @Column(name = "ma_co_so_dao_tao_nguoi_dung")
    private String maCoSoDaoTaoNguoiDung;

    // Getters and Setters
}

