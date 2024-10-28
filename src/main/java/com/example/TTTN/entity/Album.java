package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "deleted_at")
    private Integer deleteAt;
}
