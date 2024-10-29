package com.example.TTTN.controller.truongphongpr;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.entity.DotVietBai;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.repository.DotVietBaiRepository;
import com.example.TTTN.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/danhsachbaiviet")
public class DSBVController {
    @Autowired
    BaiVietRepository baiVietRepository;
    @Autowired
    ChuDeRepository chuDeRepository;
    @Autowired
    DotVietBaiRepository dotVietBaiRepository;
    @Autowired
    BaiVietService baiVietService;
    @GetMapping("/hienthi")
    public String hienthi(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "tieude", required = false) String tieude,
                          @RequestParam(value = "tencd", required = false) Integer tencd,
                          @RequestParam(value = "trangThai", required = false, defaultValue = "Đã gửi cho pr") String trangThai,
                          Model model) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        if (page < 0) {
            page = 0;
        }

        Page<BaiViet> listBV = baiVietService.hienThiBV(page, tieude, tencd, trangThai);
        model.addAttribute("totalPage", listBV.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("listbv", listBV.getContent());
        model.addAttribute("tieude", tieude);
        model.addAttribute("tencd", tencd);
        model.addAttribute("trangThai", trangThai);
        return "/truong-phong-pr/quan-ly-danh-sach-bai-viet";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model,
                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        Pageable pageable = PageRequest.of(pageNo - 1, 2);
        Page<BaiViet> listBV = baiVietRepository.findAll(pageable);
        model.addAttribute("BaiViet", baiVietRepository.getReferenceById(id));
        model.addAttribute("totalPage", listBV.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listbv", listBV);
        return "/truong-phong-pr/DetailDSBV";
    }

    @GetMapping("/dongy/{id}")
    public String dongy(@PathVariable("id") Integer id) {
        BaiViet baiViet = baiVietRepository.getReferenceById(id);
        baiViet.setTrangThai("Đã đăng");
        baiVietRepository.save(baiViet);
        return "redirect:/danhsachbaiviet/hienthi";
    }

    @GetMapping("/tuchoi/{id}")
    public String tuchoi(@PathVariable("id") Integer id) {
        BaiViet baiViet = baiVietRepository.getReferenceById(id);
        baiViet.setTrangThai("Đã hủy");
        baiVietRepository.save(baiViet);
        return "redirect:/danhsachbaiviet/hienthi";
    }

    @GetMapping("/lammoi")
    public String lammoi() {
        return "redirect:/danhsachbaiviet/hienthi";
    }

    @ModelAttribute("ListCD")
    public List<ChuDe> listcd() {
        return chuDeRepository.findAll();
    }

    @ModelAttribute("ListDVB")
    public List<DotVietBai> listdvb() {
        return dotVietBaiRepository.findAll();
    }

}
