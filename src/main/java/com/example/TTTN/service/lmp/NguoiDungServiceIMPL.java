package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.NguoiDung;
import com.example.TTTN.repository.NguoiDungRepository;
import com.example.TTTN.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungServiceIMPL implements NguoiDungService {
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    public List<NguoiDung> getAllNguoiDung() {
        return nguoiDungRepository.findAll();
    }
    public List<NguoiDung> getAllGiangVien() {
        return nguoiDungRepository.findGiangVien();
    }

}
