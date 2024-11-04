package com.example.TTTN.controller.admin;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.entity.DotVietBai;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.repository.DotVietBaiRepository;
import com.example.TTTN.service.BaiVietService;
import com.example.TTTN.service.lmp.BaiVietServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;


@Controller
@RequestMapping("/admin/phe-duyet-bai-viet")

public class PheDuyetBaiVietController {
    @Autowired
    BaiVietRepository baiVietRepository;
    @Autowired
    ChuDeRepository chuDeRepository;
    @Autowired
    DotVietBaiRepository dotVietBaiRepository;
    @Autowired
    BaiVietServiceIMPL baiVietServiceIMPL;

    @ModelAttribute("chuDe")
    public List<ChuDe> listChuDe() {
        return chuDeRepository.findAll();
    }

    @ModelAttribute("dotVietBai")
    public List<DotVietBai> listdvb() {
        return dotVietBaiRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String timkiem(
            @RequestParam(defaultValue = "", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date startDate,
            @RequestParam(defaultValue = "", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "tieude", required = false) String tieude,
            @RequestParam(value = "tencd", required = false) Integer tencd,
            @RequestParam(value = "trangThai", required = false, defaultValue = "Chờ phê duyệt") String trangThai,
            Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        if (page < 0) {
            page = 0;
        }
        Calendar calendar = Calendar.getInstance();
        // Nếu date2 không được cung cấp, đặt nó là ngày hiện tại
        if (endDate == null) {
            endDate = calendar.getTime();
        }

        // Nếu date1 không được cung cấp, đặt nó là ngày này của năm ngoái
        if (startDate == null) {
            calendar.add(Calendar.YEAR, -100);
            startDate = calendar.getTime();
        }
        Page<BaiViet> listBV = baiVietServiceIMPL.hienThiBVPD(page,tieude,tencd,trangThai,startDate,endDate);
        model.addAttribute("totalPage", listBV.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("listbv", listBV.getContent());
        model.addAttribute("tieude", tieude);
        model.addAttribute("tencd", tencd);
        model.addAttribute("trangThai", trangThai);
        return "admin/quan-ly-phe-duyet-bai-viet";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        model.addAttribute("BaiViet", baiVietRepository.getReferenceById(id));
        return "admin/quan-ly-phe-duyet-bai-viet-chi-tiet";
    }

    @GetMapping("/pheduyet/{id}")
    public String dongy(@PathVariable("id") Integer id) {
        BaiViet baiViet = baiVietRepository.getReferenceById(id);
        baiViet.setTrangThai("Đã phê duyệt");
        baiVietRepository.save(baiViet);
        return "redirect:/admin/phe-duyet-bai-viet/hien-thi";
    }

    @GetMapping("/khongpheduyet/{id}")
    public String tuchoi(@PathVariable("id") Integer id) {
        BaiViet baiViet = baiVietRepository.getReferenceById(id);
        baiViet.setTrangThai("Từ chối phê duyệt");
        baiVietRepository.save(baiViet);
        return "redirect:/admin/phe-duyet-bai-viet/hien-thi";
    }
}
