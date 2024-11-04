package com.example.TTTN.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietCusTomer {

    @Id
    private Integer id;
    private String tieuDe;
    private String tacGia;
    private String chuDe;
    private String noiDung;
    private Date ngayTao;
    private String trangThai;
}
