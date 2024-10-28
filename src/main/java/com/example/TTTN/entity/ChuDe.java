package com.example.TTTN.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

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

    @Column(name = "ten",length = 255)
    @NotBlank(message = "Tên chủ đề không được để trống")
    @Size(max = 255, message = "Tên chủ đề không được vượt quá 255 ký tự")
    private String ten;

    @Column(name = "nhuan_but")
    @NotNull(message = "Nhuận bút không được để trống")
    @Min(value = 0, message = "Nhuận bút phải lớn hơn hoặc bằng 0")
    private Double nhuanBut;

    @Column(name = "mo_ta",length = 255)
    @NotBlank(message = "Mô tả không được để trống")
    @Size(max = 255, message = "Mô tả không được vượt quá 255 ký tự")
    private String moTa;

    @Column(name = "trang_thai")
    private String trangThai;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updateAt;

    @Column(name = "deleted_at")
    private Integer deleteAt;

}
