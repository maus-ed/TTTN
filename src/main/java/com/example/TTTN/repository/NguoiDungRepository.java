package com.example.TTTN.repository;


import com.example.TTTN.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    @Query("SELECT u FROM NguoiDung u WHERE u.vaiTro = 1")
    List<NguoiDung> findGiangVien();

}
