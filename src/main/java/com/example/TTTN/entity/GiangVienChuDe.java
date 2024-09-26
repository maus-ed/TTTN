package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private Boolean deletedAt;
}
