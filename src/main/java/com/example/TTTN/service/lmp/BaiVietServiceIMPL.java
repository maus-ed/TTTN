package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BaiVietServiceIMPL implements BaiVietService {
    @Autowired
    BaiVietRepository baiVietRepository;
    @Override
    public List<BaiViet> getAll() {
        return baiVietRepository.findAll();
    }

    @Override
    public Page<BaiViet> getAll1(Pageable pageable) {
        return baiVietRepository.findAll(pageable);
    }

    @Override
    public Page<BaiViet> searchArticles(String searchTitle, String status, Date startDate, Date endDate, Pageable pageable) {
        return baiVietRepository.searchArticles(searchTitle,status,startDate,endDate,pageable);
    }

    @Override
    public BaiViet getBaiViet(Integer id) {
        return baiVietRepository.getReferenceById(id);
    }

    @Override
    public long countByStatus(String status, Date startDate, Date endDate) {
        return baiVietRepository.countByStatus(status, startDate, endDate);
    }

    @Override
    public Page<Object[]> thongKeGiangVien(Date startDate, Date endDate, Pageable pageable) {
        return baiVietRepository.thongKeGiangVien(startDate, endDate, pageable);
    }

    @Override
    public Page<BaiViet> findByDateRange(Date startDate, Date endDate, Pageable pageable) {
        return baiVietRepository.findByDateRange(startDate, endDate, pageable);
    }
    private final int size = 5;

    public Page<BaiViet> hienThiBVPD(int page, String tieude, Integer tencd, String trangThai, Date start, Date end) {
        if (page < 0) {
            throw new IllegalArgumentException("Chỉ số trang không được nhỏ hơn số không");
        }
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return baiVietRepository.findBV(tieude, tencd,start,end, trangThai, pageable);
    }

}
