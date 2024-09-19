package com.example.TTTN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorSwitchController {
    @GetMapping("/author-switch")
    public String showAuthorSwitch() {
        return "author-switch";
    }

    @PostMapping("/switch-role")
    public String switchRole(@RequestParam("role") String role, Model model) {
        model.addAttribute("role", role);

        // Điều hướng tới các trang tương ứng với từng role
        if ("admin".equals(role)) {
            return "redirect:/admin/thong-ke"; // Admin: chuyển đến trang quản lý album
        } else if ("lecturer".equals(role)) {
            return "redirect:/giang-vien/dang-ky-bai-viet"; // Lecturer: chuyển đến trang quản lý khóa học
        } else if ("pr-head".equals(role)) {
            return "redirect:/truong-phong-pr/thong-ke"; // PR Head: chuyển đến trang quản lý chiến dịch PR
        } else if ("pr-staff".equals(role)) {
            return "redirect:/nhan-vien-pr/quan-ly-danh-sach-bai-viet-pr"; // PR Staff: chuyển đến trang quản lý bài viết
        } else {
            return "redirect:/dashboard"; // Trường hợp không xác định, quay về dashboard
        }
    }
}
