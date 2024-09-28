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
    private String tieuDe;
    private String chuDe;
    private String noiDung;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt; // Thay ngayTao bằng createAt

    private String nguoiTao;
    private int dot;
    private String trangThai;
}
