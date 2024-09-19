package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "album_bai_viet")
public class AlbumBaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "bai_viet_id")
    private BaiViet baiViet;
}
