package com.example.TTTN.repository;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.dto.DotDangKyDTO;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.DotDangKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DotDangKyRepository extends JpaRepository<DotDangKy, Integer> {
    @Query("""
        SELECT new com.example.TTTN.dto.DotDangKyDTO(ddk.id, ddk.ma, ddk.ten, concat(ddk.ngayBatDau, ' - ' , ddk.ngayKetThuc) , ddk.trangThai)  
        FROM DotDangKy ddk
""")
    List<DotDangKyDTO> getDotDangKyList();

    @Query("""
        SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.tieuDe, bv.chude.ten, bv.noiDung, bv.ngayTao, bv.dotVietBai.ten, bv.trangThai)
        FROM BaiViet bv
""")
    List<BaiVietDTO> getBaiVietList();
}