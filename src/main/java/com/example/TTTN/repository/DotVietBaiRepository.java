package com.example.TTTN.repository;


import com.example.TTTN.dto.DotVietBaiCuaToiDTO;
import com.example.TTTN.entity.DotVietBai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DotVietBaiRepository extends JpaRepository<DotVietBai,Integer> {
    @Query("""
SELECT new com.example.TTTN.dto.DotVietBaiCuaToiDTO(dvb.id, dvb.ten, dvb.trangThai, dvb.soLuongBaiViet)  
FROM DotVietBai dvb
JOIN DotDangKy ddk on ddk.id = dvb.dotDangKy.id
JOIN NguoiDungDangKy nddk ON nddk.dotVietBai.id = dvb.id
WHERE nddk.nguoiDung.id = :id
AND dvb.trangThai LIKE :trangThai
AND CURRENT_DATE BETWEEN dvb.tuNgay AND dvb.denNgay
""")
    List<DotVietBaiCuaToiDTO> dotVietBaiCuaToi(@Param("id") Integer id, String trangThai);
}
