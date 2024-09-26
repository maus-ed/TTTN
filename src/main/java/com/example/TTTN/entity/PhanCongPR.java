package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data@Entity@Table(name = "phan_cong_pr")
public class PhanCongPR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chu_de_id")
    private ChuDe chuDe;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    private NguoiDung nguoiDung;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_phan_cong")
    private Date ngayPhanCong;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Integer deletedAt;
}
