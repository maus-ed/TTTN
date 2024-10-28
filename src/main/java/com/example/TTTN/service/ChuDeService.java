package com.example.TTTN.service;

import com.example.TTTN.entity.ChuDe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ChuDeService {

    List<ChuDe> getAll();

    ChuDe add(ChuDe chuDe);

    public Integer genMaTuDong();

    ChuDe getById(Integer id);

    Page<ChuDe>search(String ten, String trangThai,Double minNhuanBut ,Double maxNhuanBut, Pageable pageable);

    ChuDe update(ChuDe chuDe);

    boolean existsByTen(String ten);
 }
