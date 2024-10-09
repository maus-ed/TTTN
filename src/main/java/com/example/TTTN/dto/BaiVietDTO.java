package com.example.TTTN.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietDTO {
    private Integer id;
    private String tieuDe;
    private String tacGia;
    private String chude;
    private String noiDung;
    private Date ngayTao;
    private Integer idDotVietBai;
    private Integer trangThai;
}
