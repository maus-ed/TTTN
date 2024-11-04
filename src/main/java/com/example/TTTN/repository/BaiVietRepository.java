package com.example.TTTN.repository;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.Album;
import com.example.TTTN.entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai) 
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
""")
    Page<BaiVietDTO> findBaiViet(Pageable pageable);

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai) 
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
""")
    List<BaiVietDTO> findBaiViet1();

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai) 
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    where bv.id=:id
""")
    BaiVietDTO findBaiVietById(Integer id);

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai) 
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    WHERE (:tieuDe IS NULL OR bv.tieuDe LIKE %:tieuDe%)
    AND (:chuDe IS NULL OR cd.ten LIKE %:chuDe%)
    AND (:dotVietBaiId IS NULL OR dvb.id = :dotVietBaiId)
""")
    List<BaiVietDTO> findBaiVietByFilters(
            @Param("tieuDe") String tieuDe,
            @Param("chuDe") String chuDe,
            @Param("dotVietBaiId") Integer dotVietBaiId
    );

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai)\s
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    WHERE (:tieuDe IS NULL OR bv.tieuDe LIKE %:tieuDe%)
    AND (:chuDe IS NULL OR cd.ten LIKE %:chuDe%)
    AND (:dotVietBaiId IS NULL OR dvb.id = :dotVietBaiId)
""")
    Page<BaiVietDTO> findBaiVietByFilters1(
            Pageable pageable,
            @Param("tieuDe") String tieuDe,
            @Param("chuDe") String chuDe,
            @Param("dotVietBaiId") Integer dotVietBaiId
    );

    @Query("""
    SELECT COUNT(*)
    FROM BaiViet bv
    WHERE bv.nguoiDung.id = :id
""")
    Long tongBaiViet(@Param("id") Integer id);

    @Query("""
    SELECT COUNT(*)
    FROM BaiViet bv
    WHERE bv.nguoiDung.id = :id
    AND bv.trangThai = :trangThai
""")
    Long baiVietTrangThai(@Param("id") Integer id, @Param("trangThai") String trangThai);

    @Query("""
    SELECT new com.example.TTTN.dto.BaiVietDTO(bv.id, bv.ngayTao, bv.chuDe.ten, bv.tieuDe, bv.noiDung, bv.noiDungMoTa, bv.moTaNgan, bv.nguoiDung.ten, ddk.ten, bv.nhanVienPrId, bv.trangThai)
    FROM BaiViet bv
    join ChuDe cd on bv.chuDe.id = cd.id
    join NguoiDungDangKy nddk on nddk.chuDe.id = cd.id
    join DotVietBai dvb on nddk.dotVietBai.id = dvb.id
    join DotDangKy ddk on dvb.dotDangKy.id = ddk.id
    WHERE bv.nguoiDung.id = :id
    AND (:trangThai IS NULL OR bv.trangThai = :trangThai)
""")
    List<BaiVietDTO> baiVietCuaToiTrangThai(@Param("id") Integer id, @Param("trangThai") String trangThai);


    @Query("SELECT bv FROM BaiViet bv WHERE "
            + "(:searchTitle IS NULL OR bv.tieuDe LIKE :searchTitle)"
            + "AND (:status IS NULL OR bv.trangThai = :status) "
            + "AND (:startDate IS NULL OR bv.ngayTao >= :startDate) "
            + "AND (:endDate IS NULL OR bv.ngayTao <= :endDate)")
    Page<BaiViet> searchArticles(@Param("searchTitle") String searchTitle,
                                 @Param("status") String status,
                                 @Param("startDate") Date startDate,
                                 @Param("endDate") Date endDate,
                                 Pageable pageable);

    @Query("SELECT COUNT(b) FROM BaiViet b WHERE b.trangThai = :status " +
            "AND (:startDate IS NULL OR b.ngayTao >= :startDate) " +
            "AND (:endDate IS NULL OR b.ngayTao <= :endDate)")
    long countByStatus(@Param("status") String status,
                       @Param("startDate") Date startDate,
                       @Param("endDate") Date endDate);

    @Query("SELECT gv.ten, COUNT(b.id) FROM BaiViet b JOIN b.nguoiDung gv " +
            "WHERE (:startDate IS NULL OR b.ngayTao >= :startDate) " +
            "AND (:endDate IS NULL OR b.ngayTao <= :endDate) " +
            "GROUP BY gv.ten")
    Page<Object[]> thongKeGiangVien(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query("SELECT b FROM BaiViet b " +
            "WHERE (:startDate IS NULL OR b.ngayTao >= :startDate) " +
            "AND (:endDate IS NULL OR b.ngayTao <= :endDate)")
    Page<BaiViet> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);


    @Query("SELECT dm FROM BaiViet dm WHERE " +
            "(?1 IS NULL OR dm.tieuDe LIKE %?1% OR dm.nguoiDung.ten LIKE %?1%) AND " +
            "(?2 IS NULL OR dm.chuDe.id = ?2) AND " +
            "(dm.ngayTao between ?3 and ?4) AND " +
            "dm.trangThai = ?5")
    Page<BaiViet> findBV(String tieude, Integer tencd, Date startDate, Date endDate, String trangThai, Pageable pageable);
}
