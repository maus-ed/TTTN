package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "album_bai_viet")
@IdClass(AlbumBaiVietId.class)
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // Nên là LocalDateTime

    // Tự động set thời gian khi tạo mới
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Tự động set thời gian khi update
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
