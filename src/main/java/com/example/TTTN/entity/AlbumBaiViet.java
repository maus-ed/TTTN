package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "album_bai_viet")
@IdClass(AlbumBaiVietId.class)  // Khóa chính phức hợp
public class AlbumBaiViet {
    @Column(name = "trang_thai")
    private String trangThai;

    @Id
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

    @Id
    @ManyToOne
    @JoinColumn(name = "bai_viet_id", referencedColumnName = "id")
    private BaiViet baiViet;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Integer deletedAt;
}
