package com.example.TTTN.controller.giangvien;

import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/giang-vien")
public class BaiVietCuaToiRest {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @GetMapping("/list-cua-toi")
    public ResponseEntity<?> listBaiViet() {
        return ResponseEntity.ok(baiVietRepository.baiVietCuaToiYeuThich(2));
    }
}
