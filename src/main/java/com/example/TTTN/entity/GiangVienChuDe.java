package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "giang_vien_chu_de")
public class GiangVienChuDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "chu_de_id")
    private ChuDe chuDe;

    @Column(name = "ngay_phan_cong")
    private Date ngayPhanCong;

    @Column(name = "trang_thai")
    private int trangThai;


}
