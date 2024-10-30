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

import java.util.Date;

@Service
public class BaiVietServiceIMPL implements BaiVietService {
    @Autowired
    BaiVietRepository baiVietRepository;
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
