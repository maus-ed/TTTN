package com.example.TTTN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
    // Phê duyệt bài viết cho admin
    @GetMapping("/admin/phe-duyet-bai-viet")
    public String pheDuyetBaiViet(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/quan-ly-phe-duyet-bai-viet";  // Trả về file HTML trong folder templates/admin
    }

    // Thống kê cho admin
    @GetMapping("/admin/thong-ke")
    public String thongKe(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/quan-ly-thong-ke";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/admin/lich-su-phe-duyet")
    public String ls(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/quan-ly-lich-su-phe-duyet";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/admin/kho-luu-tru")
    public String kholt(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/quan-ly-kho-luu-tru";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/admin/dot-dang-ky")
    public String ddk(Model model) {
        String role = "admin"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/admin/quan-ly-dot-dang-ky";  // Trả về file HTML trong folder templates/admin
    }

    // Đăng ký bài viết cho giảng viên
    @GetMapping("/giang-vien/dang-ky-bai-viet")
    public String dangKyBaiViet(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/dang-ky-bai-viet";  // Trả về file HTML trong folder templates/admin
    }

    // Quản lý album cho giảng viên
    @GetMapping("/giang-vien/album")
    public String quanLyAlbum(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-album";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/giang-vien/bai-viet-cua-toi")
    public String baivietct(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-bai-viet-cua-toi";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/giang-vien/bai-viet-yeu-thich")
    public String baivietyeuthich(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-bai-viet-yeu-thich";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/giang-vien/danh-sach-bai-viet")
    public String dsbv(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-danh-sach-bai-viet";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/giang-vien/lich-su-da-xem")
    public String lsdx(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-lich-su-da-xem";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/giang-vien/tao-bai-viet")
    public String taobv(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/giang-vien/quan-ly-tao-bai-viet";  // Trả về file HTML trong folder templates/admin
    }

    // Danh sách bài viết cho nhân viên PR
    @GetMapping("/nhan-vien-pr/quan-ly-danh-sach-bai-viet-pr")
    public String quanlydanhsach(Model model) {
        String role = "pr-staff"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/nhan-vien-pr/quan-ly-danh-sach-bai-viet";  // Trả về file HTML trong folder templates/admin
    }

    // Quản lý chủ đề cho trưởng phòng
//    @GetMapping("/truong-phong-pr/quan-ly-chu-de")
//    public String quanLyChuDe(Model model) {
//        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role); // Truyền role xuống view
//        return "/truong-phong-pr/quan-ly-chu-de";  // Trả về file HTML trong folder templates/admin
//    }
    @GetMapping("/truong-phong-pr/danh-sach-bai-viet")
    public String quanLyChuDe1(Model model) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/truong-phong-pr/quan-ly-danh-sach-bai-viet";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/truong-phong-pr/danh-sach-nhan-vien-pr")
    public String quanLyChuDe3(Model model) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/truong-phong-pr/quan-ly-danh-sach-nhan-vien-pr";  // Trả về file HTML trong folder templates/admin
    }
    @GetMapping("/truong-phong-pr/thong-ke")
    public String quanLyChuDe4(Model model) {
        String role = "pr-head"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        return "/truong-phong-pr/quan-ly-thong-ke-pr";  // Trả về file HTML trong folder templates/admin
    }
}

