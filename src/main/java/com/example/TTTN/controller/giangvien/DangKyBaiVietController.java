package com.example.TTTN.controller.giangvien;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.DotDangKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DangKyBaiVietController {
    @Autowired
    BaiVietRepository baiVietRepository;

    @Autowired
    DotDangKyRepository dotDangKyRepository;

    @GetMapping("/view")
    public ResponseEntity<?> view(){
        return ResponseEntity.ok(baiVietRepository.findAll());
    }

    @GetMapping("/giang-vien/list-dot-dang-ky")
    public ResponseEntity<?> dotdangky(){
        return ResponseEntity.ok(dotDangKyRepository.getDotDangKyList());
    }

    @GetMapping("/giang-vien/list-bai-viet")
    public ResponseEntity<?> danhsachbaiviet(){
        return ResponseEntity.ok(dotDangKyRepository.getBaiVietList());
    }
}