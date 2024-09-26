package com.example.TTTN.controller.giangvien;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/giang-vien")
public class QuanLyBaiVietController {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @GetMapping("/danh-sach-bai-viet")
    public String listBaiViet(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        // Lấy danh sách bài viết từ repository
        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiViet();

        // Truyền danh sách bài viết vào model
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        // Trả về view để hiển thị danh sách bài viết
        return "giang-vien/quan-ly-danh-sach-bai-viet";
    }

    @GetMapping("/danh-sach-bai-viet/{id}")
    public String chiTietBaiViet(@PathVariable("id") Integer id, Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        // Lấy chi tiết bài viết từ repository
        BaiVietDTO baiViet = baiVietRepository.findBaiVietById(id);

        // Kiểm tra nếu bài viết không tồn tại
        if (baiViet == null) {
            // Bạn có thể trả về một trang lỗi hoặc chuyển hướng đến trang khác
            return "redirect:/error"; // Hoặc bạn có thể hiển thị một thông báo
        }

        // Thêm bài viết vào model
        model.addAttribute("baiViet", baiViet);
        return "giang-vien/quan-ly-danh-sach-bai-viet"; // Tên của template chi tiết
    }

    @PostMapping("/danh-sach-bai-viet/add-album/{id}")
    public String addAlbum(@PathVariable("id") Integer id, Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        // Lấy chi tiết bài viết từ repository

        BaiVietDTO baiViet = baiVietRepository.findBaiVietById(id);

        // Kiểm tra nếu bài viết không tồn tại
        if (baiViet == null) {
            // Bạn có thể trả về một trang lỗi hoặc chuyển hướng đến trang khác
            return "redirect:/error"; // Hoặc bạn có thể hiển thị một thông báo
        }

        // Thêm bài viết vào model
        model.addAttribute("baiViet", baiViet);
        return "giang-vien/quan-ly-danh-sach-bai-viet"; // Tên của template chi tiết
    }

}
