package com.example.TTTN.repository;

import com.example.TTTN.entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet,Integer> {
    @Query(value = "SELECT *\n" +
            "FROM     bai_viet where\n" +
            "bai_viet.trang_thai like N'%Đã gửi cho pr%'",nativeQuery = true)
    List<BaiViet> listbv();
//    Page<BaiViet> findByTieuDe(String keyword,Pageable pageable);

    @Query("SELECT dm FROM BaiViet dm WHERE " +
            "(?1 IS NULL OR dm.tieuDe LIKE %?1% OR dm.nguoiDung.ten LIKE %?1%) AND " +
            "(?2 IS NULL OR dm.chuDe.id = ?2) AND " +
            "dm.trangThai = ?3")
    Page<BaiViet> findByDV(String tieude, Integer tencd, String trangThai, Pageable pageable);





}
