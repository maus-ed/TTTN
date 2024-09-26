package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "thong_bao")
public class ThongBao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "nguoi_phan_cong_id")
    private NguoiDung nguoiPhanCong;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "loai_thong_bao")
    private String loaiThongBao;

    @Column(name = "lien_ket_lien_quan")
    private String lienKetLienQuan;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "delete_at")
    private Integer deleteAt;
}
