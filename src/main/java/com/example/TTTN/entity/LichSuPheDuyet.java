package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "lich_su_phe_duyet")
public class LichSuPheDuyet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bai_viet_id")
    private BaiViet baiViet;

    @ManyToOne
    @JoinColumn(name = "quan_tri_id")
    private NguoiDung quanTri;

    @Column(name = "hanh_dong")
    private String hanhDong;

    @Column(name = "ngay_thao_tac")
    private Date ngayThaoTac;

    @Column(name = "ghi_chu", columnDefinition = "TEXT")
    private String ghiChu;

    @Column(name = "trangThai")
    private String trangThai;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "delete_at")
    private Integer deleteAt;
}
