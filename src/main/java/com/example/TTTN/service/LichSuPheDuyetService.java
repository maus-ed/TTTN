package com.example.TTTN.service;

import com.example.TTTN.entity.LichSuPheDuyet;

import java.util.List;

public interface LichSuPheDuyetService {
    List<LichSuPheDuyet> find(Integer baiVietId);
}
