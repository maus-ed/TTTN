package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "nen")
    private String nen;

    @Column(name = "ma")
    private String ma;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "ten")
    private String ten;

    @Column(name = "vai_tro")
    private Integer vaiTro;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;

    @Column(name = "ma_co_so_dao_tao_nguoi_dung")
    private String maCoSoDaoTaoNguoiDung;

    // Getters and Setters
}
