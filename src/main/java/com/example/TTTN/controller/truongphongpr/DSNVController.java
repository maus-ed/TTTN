package com.example.TTTN.controller.truongphongpr;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.entity.NguoiDung;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/danh-sach-nhan-vien")
public class DSNVController {
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @GetMapping("/hienthi")
    public String hienthi(Model model, @RequestParam(name="pageNo", defaultValue = "1") Integer pageNo){
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        Pageable pageable = PageRequest.of(pageNo - 1, 2);
        Page<NguoiDung> listNV = nguoiDungRepository.findAll(pageable);
        model.addAttribute("totalPage", listNV.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listnv", listNV);
        model.addAttribute("NguoiDung", new NguoiDung());
        return "/truong-phong-pr/quan-ly-danh-sach-nhan-vien-pr";
    }

}
