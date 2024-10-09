package com.example.TTTN.service;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.BaiVietCusTomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaiVietService {

    List<BaiViet> getAll();
    Page<BaiVietCusTomer> search (String key, Integer idChuDe, String trangThai,
                                  Integer idDotVietBai, Pageable pageable);


}
