package com.example.TTTN.dto;

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
    private String chude;
    private String noiDung;
    private Date ngayTao;
    private String dotVietBai;
    private Integer trangThai;
}
