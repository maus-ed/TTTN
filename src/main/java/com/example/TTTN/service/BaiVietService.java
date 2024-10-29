package com.example.TTTN.service;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BaiVietService {
    @Autowired
    BaiVietRepository baiVietRepository;
    private final int size = 5;

    public Page<BaiViet> hienThiBV(int page, String tieude, Integer tencd, String trangThai) {
        if (page < 0) {
            throw new IllegalArgumentException("Chỉ số trang không được nhỏ hơn số không");
        }
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return baiVietRepository.findByDV(tieude, tencd, trangThai, pageable);
    }

}
