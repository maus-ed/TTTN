package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "giang_vien_chu_de")
public class GiangVienChuDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id")
    private NguoiDung giangVien;

    @ManyToOne
    @JoinColumn(name = "phan_cong_pr_id")
    private ThongBao thongBao;

    @Column(name = "ngay_dang_ky")
    private Date ngayDangKy;

    @Column(name = "trang_thai")
    private String trangThai;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private java.util.Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private java.util.Date updateAt;

    @Column(name = "delete_at")
    private Integer deleteAt;
}
