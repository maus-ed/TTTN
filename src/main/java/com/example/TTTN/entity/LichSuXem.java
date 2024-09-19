package com.example.TTTN.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "lich_su_xem")
public class LichSuXem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id")
    private NguoiDung giangVien;

    @ManyToOne
    @JoinColumn(name = "bai_viet_id")
    private BaiViet baiViet;

    @Column(name = "ngay_xem")
    private Date ngayXem;
}
