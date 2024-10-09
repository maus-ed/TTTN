package com.example.TTTN.dto;

<<<<<<< HEAD
import jakarta.persistence.Entity;
=======
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
>>>>>>> d04c005397b055c7780b48bbb336c31baf500dac
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
<<<<<<< HEAD
    private String tacGia;
    private String chude;
    private String noiDung;
    private Date ngayTao;
    private Integer idDotVietBai;
    private Integer trangThai;
=======
    private String chuDe;
    private String noiDung;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt; // Thay ngayTao bằng createAt

    private String nguoiTao;
    private int dot;
    private String trangThai;
>>>>>>> d04c005397b055c7780b48bbb336c31baf500dac
}
