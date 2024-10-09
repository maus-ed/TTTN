package com.example.TTTN.repository;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.BaiVietCusTomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BaiVietRepository extends JpaRepository<BaiViet,Integer>, JpaSpecificationExecutor<BaiViet> {


//    (value = "Select bv.id, bv.tieu_de, nd.ten, cd.ten, bv.noi_dung, bv.created_at, dvb.id, bv.trang_thai\n" +
//            "From bai_viet bv \n" +
//            "Join dot_viet_bai dvb On bv.dot_viet_bai_id = dvb.id\n" +
//            "Join dot_dang_ky ddk On dvb.dot_dang_ky_id = ddk.id\n" +
//            "Join chu_de cd On ddk.chu_de_id = cd.id\n" +
//            "Join nguoi_dung nd On bv.nguoi_tao_id = nd.id\n" +
//            "Where (bv.tieu_de = :tieuDe Or :tieuDe Is Null ) \n" +
//            "\tAnd (nd.ten = :tacGia Or :tacGia Is Null )\n" +
//            "\tAnd (cd.id = :idChuDe Or :idChuDe Is Null)\n" +
//            "\tAnd (bv.trang_thai = :trangThai Or :trangThai Is Null )\n" +
//            "\tAnd (dvb.id = :idDotVietBai Or :idDotVietBai Is Null)", nativeQuery = true)

    @Query("select new BaiVietCusTomer (bv.id, bv.tieuDe, nd.ten, cd.ten, bv.noiDung, bv.createdAt, bv.trangThai) from BaiViet bv " +
            "join DotVietBai dvb on bv.dotVietBai.id = dvb.id " +
            "join DotDangKy ddk on dvb.dotDangKy.id = ddk.id " +
            "join ChuDe cd on ddk.chuDe.id = cd.id " +
            "join NguoiDung nd on bv.nguoiTao.id = nd.id " +
            "where ((bv.tieuDe like %:key% or :key is null) or (nd.ten like %:key% or :key is null)) " +
            "and (:idChuDe is null or cd.id = :idChuDe) " +
            "and (:trangThai is null or bv.trangThai like %:trangThai%) " +
            "and (:idDotVietBai is null or dvb.id = :idDotVietBai)")
    Page<BaiVietCusTomer> search(@Param("key") String key, @Param("idChuDe") Integer idChuDe,@Param("trangThai") String trangThai,
                                 @Param("idDotVietBai") Integer idDotVietBai,
                                 Pageable pageable);


    @Query("update BaiViet set trangThai = 'Đã đăng' " +
            "where id = :id")
    BaiViet changeStatus(@Param("id") Integer id);
}


