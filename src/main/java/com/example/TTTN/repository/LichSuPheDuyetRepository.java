package com.example.TTTN.repository;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.LichSuPheDuyet;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface LichSuPheDuyetRepository extends JpaRepository<LichSuPheDuyet,Integer> {
    @Query("SELECT l from LichSuPheDuyet l JOIN BaiViet b on l.baiViet.id = b.id where l.baiViet.id = :baiVietId order by l.ngayTao")
    List<LichSuPheDuyet> find(Integer baiVietId);
}
