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

    @ManyToOne
    @JoinColumn(name = "dot_dang_ky_id")
    private DotDangKy dotDangKy;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "so_luong_da_nhan")
    private int soLuongDaNhan;

    @Column(name = "so_nguoi_phan_cong")
    private int soNguoiPhanCong;

    @Column(name = "trang_thai")
    private String trangThai;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "deleted_at")
    private Integer deleteAt;

}
