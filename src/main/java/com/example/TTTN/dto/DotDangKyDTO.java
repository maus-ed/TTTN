package com.example.TTTN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DotDangKyDTO {
    private Integer id;
    private String ma;
    private String ten;
    private String thoiGian;
    private int trangThai;
}
