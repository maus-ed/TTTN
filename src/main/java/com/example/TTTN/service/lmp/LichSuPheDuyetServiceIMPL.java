package com.example.TTTN.service.lmp;

import com.example.TTTN.entity.LichSuPheDuyet;
import com.example.TTTN.repository.LichSuPheDuyetRepository;
import com.example.TTTN.service.LichSuPheDuyetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class LichSuPheDuyetServiceIMPL implements LichSuPheDuyetService {
    @Autowired
    LichSuPheDuyetRepository lichSuPheDuyetRepository;
    @Override
    public List<LichSuPheDuyet> find(Integer baiVietId) {
        return lichSuPheDuyetRepository.find(baiVietId);
    }
}
