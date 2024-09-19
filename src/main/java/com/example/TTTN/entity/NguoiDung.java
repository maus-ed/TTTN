package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "vai_tro")
    private Integer vaiTro;

    @Column(name = "so_luong_bai_viet")
    private Integer soLuongBaiViet;

    @Column(name = "chu_de")
    private String chuDe;

}
