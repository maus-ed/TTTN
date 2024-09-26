package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.service.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
