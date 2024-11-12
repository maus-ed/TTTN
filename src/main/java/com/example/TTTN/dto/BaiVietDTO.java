package com.example.TTTN.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietDTO {
    private int id;

    @Temporal(TemporalType.DATE)
    private Date ngayTao; // Thay ngayTao bằng createAt

    private String chuDe;

    private String tieuDe;

    private String noiDung;

    private String noiDungMoTa;

    private String moTaNgan;

    private String nguoiTao;

    private String dot;

    private Integer nhanVienPrId;

    private String trangThai;
}
