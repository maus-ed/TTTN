package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "dot_dang_ky")
public class DotDangKy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private LocalDate ngayChinhSuaCuoi;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ngay_ket_thuc_dang_ky")
    private LocalDate ngayKetThucDangKy;

    @Column(name = "tu_ngay")
    private LocalDate tuNgay;

    @Nationalized
    @Column(name = "ten")
    private String ten;

    @Nationalized
    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_bat_dau_dang_ky")
    private LocalDate ngayBatDauDangKy;

    @Column(name = "den_ngay")
    private LocalDate denNgay;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;
    @PrePersist
    public void prePersist() {
        // Tạo mã duy nhất (có thể là UUID hoặc mã định dạng riêng của bạn)
        this.ma = "DK" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Đặt ngày tạo là ngày hiện tại nếu chưa có
        if (this.ngayTao == null) {
            this.ngayTao = LocalDate.now();
        }
    }
}