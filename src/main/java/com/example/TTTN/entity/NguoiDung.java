package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ngay_tao")
    private Instant ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Instant ngayChinhSuaCuoi;

    @Lob
    @Column(name = "nen")
    private String nen;

    @Column(name = "ma")
    private String ma;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Nationalized
    @Column(name = "ten")
    private String ten;

    @Column(name = "vai_tro")
    private Integer vaiTro;

    @Nationalized
    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ma_dang_ky_nguoi_dung")
    private String maDangKyNguoiDung;

    @Column(name = "ma_co_so_dao_tao_nguoi_dung")
    private String maCoSoDaoTaoNguoiDung;

    @Column(name = "email")
    private String email;

}