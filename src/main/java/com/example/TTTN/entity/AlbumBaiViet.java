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
    @Column(name = "create_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "delete_at")
    private Integer deleteAt;
}
