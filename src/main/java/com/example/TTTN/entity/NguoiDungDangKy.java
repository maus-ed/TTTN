package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "nguoi_dung_dang_ky")
public class NguoiDungDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @ManyToOne
    @JoinColumn(name = "chu_de_id")
    private ChuDe chuDe;

    @Column(name = "so_luong_bai_viet")
    private Integer soLuongBaiViet;

    @ManyToOne
    @JoinColumn(name = "dot_viet_bai_id")
    private DotVietBai dotVietBai;

    @Column(name = "trang_thai_nhac_nho")
    private Integer trangThaiNhacNho;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    // Getters and Setters
}

