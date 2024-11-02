package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.DotDangKy;
import com.example.TTTN.repository.DotDangKyRepository;
import com.example.TTTN.service.DotDangKyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DotDangKyServiceIMPL implements DotDangKyService {

    @Autowired
    private DotDangKyRepository dotDangKyRepository;

    private static final Logger logger = LoggerFactory.getLogger(DotDangKyService.class);

    public List<DotDangKy> getDotDangKyList() {
         return dotDangKyRepository.findAll();
    }
    public DotDangKy getDotDangKyById(int id) {
        return dotDangKyRepository.findById(id).get();
    }
    public void saveOrUpdateDotDangKy(DotDangKy dotDangKy) {
        dotDangKyRepository.save(dotDangKy);
    }

    public Page<DotDangKy> getDotDangKyList(Pageable pageable) {
        return dotDangKyRepository.findAll(pageable);
    }

    public Page<DotDangKy> searchByCriteria(String ten, String trangThai, LocalDate ngayTao, LocalDate denNgay, Pageable pageable) {
        logger.info("Searching with parameters: ten={}, trangThai={}, ngayTao={}, denNgay={}", ten, trangThai, ngayTao, denNgay);
        return dotDangKyRepository.searchByCriteria(ten,ten, trangThai, ngayTao, denNgay, pageable);
    }


}
