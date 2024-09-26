package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "bai_viet")
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "trang_thai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "nguoi_tao_id")
    private NguoiDung nguoiTao;

    @ManyToOne
    @JoinColumn(name = "dot_viet_bai_id")
    private DotVietBai dotVietBai;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "delete_at")
    private Integer deleteAt;
}
