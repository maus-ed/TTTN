package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "bai_viet")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "ngay_duyet")
    private Date ngayDuyet;

    @ManyToOne
    @JoinColumn(name = "chu_de_id")
    private ChuDe chuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "noi_dung_mo_ta")
    private String noiDungMoTa;

    @Column(name = "mo_ta_ngan")
    private String moTaNgan;

    @Column(name = "ngay_danh_gia")
    private Date ngayDanhGia;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "tieu_de")
    private String tieuDe;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    @Column(name = "ma_duyet")
    private String maDuyet;

    @Column(name = "noi_bat")
    private Boolean noiBat;

    @Column(name = "nhan_vien_pr_id")
    private Integer nhanVienPrId;

    @Column(name = "tien_ban_quyen")
    private BigDecimal tienBanQuyen;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;

    @Column(name = "ma_co_so_dao_tao_nguoi_dung")
    private String maCoSoDaoTaoNguoiDung;

    // Getters and Setters
}

