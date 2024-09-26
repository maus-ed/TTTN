package com.example.TTTN.controller.truongphongpr;

import com.example.TTTN.service.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class QuanLyChuDeController {

    @Autowired
    private ChuDeService chuDeService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("listCD",chuDeService.getAll());
        return "truong-phong-pr/quan-ly-chu-de";
    }
}
