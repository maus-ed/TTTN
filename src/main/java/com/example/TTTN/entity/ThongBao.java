package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "nguoi_nhan_id")
    private NguoiDung nguoiNhan;

    @Column(name = "trang_thai_doc")
    private Integer trangThaiDoc;

    @Column(name = "loai_thong_bao")
    private Integer loaiThongBao;

    @Column(name = "lien_ket_lien_quan")
    private Integer lienKetLienQuan;
}
