package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chu_de")
public class ChuDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "nhuan_but")
    private String nhuanBut;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
