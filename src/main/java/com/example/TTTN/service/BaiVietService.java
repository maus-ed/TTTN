package com.example.TTTN.service;

import com.example.TTTN.entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface BaiVietService {
    List<BaiViet> getAll();
    Page<BaiViet> getAll1(Pageable pageable);

    Page<BaiViet> searchArticles(String searchTitle, String status, Date startDate, Date endDate, Pageable pageable);

    BaiViet getBaiViet(Integer id);

    public long countByStatus(String status, Date startDate, Date endDate) ;
    public Page<Object[]> thongKeGiangVien(Date startDate, Date endDate, Pageable pageable) ;
        public Page<BaiViet> findByDateRange(Date startDate, Date endDate, Pageable pageable) ;

}
