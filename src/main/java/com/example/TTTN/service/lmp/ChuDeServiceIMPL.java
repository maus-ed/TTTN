package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.service.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuDeServiceIMPL implements ChuDeService {

    @Autowired
    private ChuDeRepository chuDeRepo;


    @Override
    public List<ChuDe> getAll() {
        return chuDeRepo.findAll();
    }

    @Override
    public ChuDe add(ChuDe chuDe) {
        Integer maTuDong = genMaTuDong();
        String maChuDe = "CD" + String.format("%03d", maTuDong);
        chuDe.setMa(maChuDe);
        return chuDeRepo.save(chuDe);
    }

    @Override
    public Page<ChuDe> search(String ten, String trangThai,Double minNhuanBut,Double maxNhuanBut , Pageable pageable) {
        return chuDeRepo.search(ten,trangThai,minNhuanBut,maxNhuanBut,pageable);
    }

    @Override
    public ChuDe update(ChuDe chuDe) {
        return chuDeRepo.save(chuDe);
    }

    @Override
    public Integer genMaTuDong() {
        Long count = chuDeRepo.count();
        return count.intValue() + 1;
    }

    @Override
    public ChuDe getById(Integer id) {
        return chuDeRepo.findById(id).orElse(null);
    }

    @Override
    public boolean existsByTen(String ten) {
        return chuDeRepo.existsByTen(ten); // Triển khai kiểm tra tên trùng
    }
}
