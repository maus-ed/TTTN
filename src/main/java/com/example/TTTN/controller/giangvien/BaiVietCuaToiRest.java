package com.example.TTTN.controller.giangvien;

import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.DotVietBaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private DotVietBaiRepository dotVietBaiRepository;

    @GetMapping("/list-cua-toi")
    public ResponseEntity<?> listBaiViet(@RequestParam(value = "id", defaultValue = "2") Integer id) {
        return ResponseEntity.ok(dotVietBaiRepository.dotVietBaiCuaToi(id, "Đang mở"));
    }
}
