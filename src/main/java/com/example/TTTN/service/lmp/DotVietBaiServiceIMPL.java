package com.example.TTTN.service.lmp;


import com.example.TTTN.entity.DotVietBai;
import com.example.TTTN.repository.DotVietBaiRepository;
import com.example.TTTN.service.DotVietBaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotVietBaiServiceIMPL implements DotVietBaiService {

    @Autowired
    private DotVietBaiRepository dotVietBaiRepository;

    @Override
    public List<DotVietBai> getAll() {
        return dotVietBaiRepository.findAll();
    }
}
