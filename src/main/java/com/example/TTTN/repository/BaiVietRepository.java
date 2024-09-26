package com.example.TTTN.repository;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaiVietRepository extends JpaRepository<BaiViet,Integer> {
    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.tieuDe, cd.ten, bv.noiDung, bv.createdAt, bv.nguoiTao.ten, dvb.id, bv.trangThai) 
    FROM BaiViet bv
    join DotVietBai dvb on bv.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    join ChuDe cd on ddk.chuDe.id = cd.id
""")
    List<BaiVietDTO> findBaiViet();

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.tieuDe, cd.ten, bv.noiDung, bv.createdAt, bv.nguoiTao.ten, dvb.id, bv.trangThai) 
    FROM BaiViet bv
    join DotVietBai dvb on bv.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    join ChuDe cd on ddk.chuDe.id = cd.id
    where bv.id=:id
""")
    BaiVietDTO findBaiVietById(Integer id);

//    @Query("""
//    INSERT INTO album_bai_viet(album_id, bai_viet_id, trang_thai) VALUES
//    (1,2,1)
//""")
//    BaiVietDTO addAlbum(Integer id);
}
