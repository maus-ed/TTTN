package com.example.TTTN.repository;

import com.example.TTTN.entity.DotDangKy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface DotDangKyRepository extends JpaRepository<DotDangKy, Integer>, JpaSpecificationExecutor<DotDangKy> {
    @Query("SELECT d FROM DotDangKy d WHERE (:ten IS NULL OR d.ten LIKE %:ten%) " +
            "AND (:ma IS NULL OR d.ma LIKE %:ma%) " +
            "AND (:trangThai IS NULL OR d.trangThai = :trangThai) " +
            "AND (:tuNgay IS NULL OR d.tuNgay >= :tuNgay) " +
            "AND (:denNgay IS NULL OR d.denNgay <= :denNgay)")
    Page<DotDangKy> searchByCriteria(@Param("ten") String ten,
                                     @Param("ma") String ma,
                                     @Param("trangThai") String trangThai,
                                     @Param("tuNgay") LocalDate tuNgay,
                                     @Param("denNgay") LocalDate denNgay,
                                     Pageable pageable);



}