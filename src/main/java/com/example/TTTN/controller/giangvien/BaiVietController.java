package com.example.TTTN.controller.giangvien;


import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.entity.DotVietBai;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.repository.DotVietBaiRepository;
import com.example.TTTN.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BaiVietController {

    @Autowired
    private BaiVietService baiVietService;
    @Autowired
    private BaiVietRepository baiVietRepository;
    @Autowired
    private DotVietBaiRepository dotVietBaiRepository;
    @Autowired
    private ChuDeRepository chuDeRepository;

    @GetMapping("/tao-bai-viet")
    public String showThemBaiVietForm(Model model) {
        List<ChuDe> chuDeList = chuDeRepository.findAll(); // Lấy danh sách chủ đề từ DB
        model.addAttribute("chuDeList", chuDeList); // Thêm vào mô hình
        return "giang-vien/taobaiviet";
    }


    @PostMapping("/api/luu-bai-viet")
    public ResponseEntity<String> saveBaiViet(@RequestParam("tieuDe") String tieuDe, @RequestParam("noiDung") String noiDung,
                                              @RequestParam("chuDe") Integer chuDeId
    ) {
        BaiViet baiViet = new BaiViet();
        baiViet.setTieuDe(tieuDe);

        ChuDe chuDe = chuDeRepository.findById(chuDeId)
                .orElseThrow(() -> new IllegalArgumentException("Chủ đề không tồn tại với ID: " + chuDeId));

        baiViet.setChuDe(chuDe);
        baiViet.setNoiDung(noiDung);
        baiViet.setTrangThai("Chờ duyệt");
        baiViet.setNgayTao(java.sql.Date.valueOf(java.time.LocalDate.now()));
        baiVietRepository.save(baiViet);

        return ResponseEntity.ok("Bài viết đã được lưu thành công!");
    }

    @GetMapping("/api/dot-viet-bai")
    public ResponseEntity<List<DotVietBai>> getDotVietBai() {
        List<DotVietBai> list = dotVietBaiRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/chude")
    public ResponseEntity<List<ChuDe>> getChuDe() {
        List<ChuDe> list = chuDeRepository.findAll();
        return ResponseEntity.ok(list);
    }



}

