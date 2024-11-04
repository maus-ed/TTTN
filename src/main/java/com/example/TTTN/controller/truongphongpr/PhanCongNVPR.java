package com.example.TTTN.controller.truongphongpr;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.ChuDeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/danh-sach-phan-cong-pr")
public class PhanCongNVPR {
    @Autowired
    BaiVietRepository baiVietRepository;
    @Autowired
    ChuDeRepository chuDeRepository;

    @GetMapping("/hienthi/{id}")
    public String hienthi(Model model,
                          @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                          @PathVariable("id") Integer id) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        List<BaiViet> listBV = baiVietRepository.listbv();
        model.addAttribute("listbaiviet", listBV);
        model.addAttribute("BaiViet", baiVietRepository.getReferenceById(id));
        return "/truong-phong-pr/PhanCongNVPr";
    }

    @ModelAttribute("ListCD")
    public List<ChuDe> listcd() {
        return chuDeRepository.findAll();
    }
    @PostMapping("/phancong")
    public String phancong(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("Add", "Phân công thành công");
        return "";
    }
}
