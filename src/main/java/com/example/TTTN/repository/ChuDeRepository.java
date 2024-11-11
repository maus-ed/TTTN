package com.example.TTTN.repository;


import com.example.TTTN.entity.ChuDe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChuDeRepository extends JpaRepository<ChuDe,Integer> {

    @Query(value = "SELECT * FROM chu_de cd WHERE " +
            "(cd.ten = ?1 OR ?1 IS NULL OR ?1 LIKE '') " +
            "AND (cd.trang_thai = ?2 OR ?2 IS NULL OR ?2 LIKE '') " +
            "AND (cd.nhuan_but BETWEEN ?3 AND ?4 OR ?3 IS NULL OR ?4 IS NULL)", nativeQuery = true)
    Page<ChuDe> search(String ten, String trangThai, Double minNhuanBut, Double maxNhuanBut, Pageable pageable);

    boolean existsByTen(String ten);

}
