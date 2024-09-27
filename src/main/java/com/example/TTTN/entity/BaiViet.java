package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private Boolean deletedAt;

    @OneToMany(mappedBy = "baiViet", cascade = CascadeType.ALL)
    private List<AlbumBaiViet> albumBaiViets;
}
