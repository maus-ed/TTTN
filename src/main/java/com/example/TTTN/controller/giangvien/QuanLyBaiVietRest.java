package com.example.TTTN.controller.giangvien;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/giang-vien")
public class QuanLyBaiVietRest {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @GetMapping("/danh-sach-bai-viet111")
    public ResponseEntity<?> listBaiViet() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiViet(pageable);
        return ResponseEntity.ok(danhSachBaiViet);
    }

    @GetMapping("/danh-sach-bai-viet2")
    public ResponseEntity<?> searchBaiViet(
            @RequestParam(value = "trangThai", required = false) String trangThai,
            Model model) {

        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiViet1();
        return ResponseEntity.status(200).body(danhSachBaiViet);
    }

}
