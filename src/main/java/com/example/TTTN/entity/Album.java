package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "trang_thai")
    private String trangThai;
    @ManyToOne
    @JoinColumn(name = "giang_vien_id")
    private NguoiDung GiangVien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private Boolean deletedAt;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<AlbumBaiViet> albumBaiViets;
}
