package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua_cuoi")
    private Date ngayChinhSuaCuoi;

    @Column(name = "tieu_de")
    private String tieuDe;

    // Getters and Setters
}

