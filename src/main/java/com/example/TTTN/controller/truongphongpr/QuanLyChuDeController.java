package com.example.TTTN.controller.truongphongpr;

import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.repository.ChuDeRepository;
import com.example.TTTN.service.ChuDeService;
import com.example.TTTN.service.lmp.ChuDeServiceIMPL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;


@Controller
@RequestMapping("/truong-phong-pr/quan-ly-chu-de")
public class QuanLyChuDeController {

    @Autowired
    private ChuDeService chuDeService;

    @GetMapping
    public String getAll(Model model,
                         @RequestParam(defaultValue = "0") int page,
                         @RequestParam(required = false) String ten,
                         @RequestParam(required = false) String trangThai,
                         @RequestParam(required = false) Double minNhuanBut,
                         @RequestParam(required = false) Double maxNhuanBut){
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        Pageable pageable = PageRequest.of(page, 3);
        Page<ChuDe> pageSP = chuDeService.search(ten, trangThai,minNhuanBut,maxNhuanBut, pageable);
        model.addAttribute("listCD", pageSP.getContent());
        model.addAttribute("tongSoTrang", pageSP.getTotalPages());
        model.addAttribute("trangHienTai", page);
        model.addAttribute("ten", ten);
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("minNhuanBut", minNhuanBut);
        model.addAttribute("maxNhuanBut", maxNhuanBut);
        return "truong-phong-pr/quan-ly-chu-de";
    }
    @GetMapping("/trang-add")
    public String trangAdd(Model model){
        String role = "pr-head";
        model.addAttribute("role", role);
        model.addAttribute("chuDe",new ChuDe());
        return "truong-phong-pr/chu-de-add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("chuDe")@Valid ChuDe chuDe ,
                      BindingResult result,
                      Model model){
        if(result.hasErrors()){
            String role = "pr-head";
            model.addAttribute("role", role);
            return "truong-phong-pr/chu-de-add";
        }else if (chuDeService.existsByTen(chuDe.getTen())) {
            result.rejectValue("ten", "error.chuDe", "Tên chủ đề đã tồn tại");
            String role = "pr-head";
            model.addAttribute("role", role);
            return "truong-phong-pr/chu-de-add";
        }
        chuDe.setTrangThai("Hoạt Động");
        chuDe.setCreateAt(Date.valueOf(LocalDate.now()));
        chuDeService.add(chuDe);
        return "redirect:/truong-phong-pr/quan-ly-chu-de";
    }
    @GetMapping("/detail/{id}")
    public String trangSua(@PathVariable("id") Integer id,
                           Model model){
        ChuDe chuDe = chuDeService.getById(id);
        String role = "pr-head";
        model.addAttribute("role", role);
        model.addAttribute("chuDe",new ChuDe());
        model.addAttribute("listUD",chuDe);
        return "truong-phong-pr/chu-de-sua";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("chuDe")@Valid ChuDe chuDe,
                         BindingResult result,
                         Model model){
        if(result.hasErrors()){
            chuDeService.getById(chuDe.getId());
            model.addAttribute("listUD",chuDe);
            String role = "pr-head";
            model.addAttribute("role", role);
            return "truong-phong-pr/chu-de-sua";
        }
        ChuDe chuDe1 = chuDeService.getById(chuDe.getId());
        String role = "pr-head";
        model.addAttribute("role", role);
        model.addAttribute("chuDe",new ChuDe());
        chuDe.setMa(chuDe1.getMa());
        chuDe.setCreateAt(chuDe1.getCreateAt());
        chuDe.setUpdateAt(Date.valueOf(LocalDate.now()));
        chuDeService.update(chuDe);
        return "redirect:/truong-phong-pr/quan-ly-chu-de";
    }
}
