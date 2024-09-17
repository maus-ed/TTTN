package com.example.TTTN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class indexController {
@GetMapping("/menu")
    public String x(Model model){

        model.addAttribute("admin","admin");
        model.addAttribute("nhanVienPR","nhanVienPR");
        model.addAttribute("giangVienBoMon","giangVienBoMon");
        model.addAttribute("truongPhongPR","truongPhongPR");
        model.addAttribute("quanLiBoMon","quanLiBoMon");
        return "menu";
}
    @GetMapping("/index/{role}")
    public String x1(@PathVariable String role, Model model){
        model.addAttribute(role,role);
        return "index";
    }
}
