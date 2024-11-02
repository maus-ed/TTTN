package com.example.TTTN.repository;


import com.example.TTTN.entity.DotVietBai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DotVietBaiRepository extends JpaRepository<DotVietBai,Integer> {

//    @Query("""
//
//""")
//    List<Object[]> countDotDangKyId();
}
