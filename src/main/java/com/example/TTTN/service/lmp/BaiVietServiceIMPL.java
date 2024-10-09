package com.example.TTTN.service.lmp;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.BaiVietCusTomer;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiVietServiceIMPL implements BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Override
    public List<BaiViet> getAll() {
        return baiVietRepository.findAll();
    }

    @Override
    public Page<BaiVietCusTomer> search(String key, Integer idChuDe, String trangThai, Integer idDotVietBai, Pageable pageable) {

        return baiVietRepository.search(key, idChuDe, trangThai, idDotVietBai, pageable);
    }

}
