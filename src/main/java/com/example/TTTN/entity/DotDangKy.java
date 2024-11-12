package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "dot_dang_ky")
public class DotDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_ket_thuc_dang_ky")
    private Date ngayKetThucDangKy;

    @Column(name = "tu_ngay")
    private Date tuNgay;

    @Column(name = "co_mo_dang_ky_khong")
    private Boolean coMoDangKyKhong;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_luong_bai_viet")
    private Integer soLuongBaiViet;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_bat_dau_dang_ky")
    private Date ngayBatDauDangKy;

    @Column(name = "den_ngay")
    private Date denNgay;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;

    @Column(name = "ma_co_so_dao_tao_nguoi_dung")
    private String maCoSoDaoTaoNguoiDung;

    // Getters and Setters
}
