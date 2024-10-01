package com.example.TTTN.controller.giangvien;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.Album;
import com.example.TTTN.repository.AlbumRepository;
import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/giang-vien")
public class QuanLyBaiVietController {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/danh-sach-bai-viet")
    public String listBaiViet(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              Model model) {
        String role = "lecturer";
        model.addAttribute("role", role);

        // Lấy danh sách bài viết không phân trang (dùng cho phần card view)
        List<BaiVietDTO> danhSachBaiViet1 = baiVietRepository.findBaiViet1();
        model.addAttribute("danhSachBaiViet1", danhSachBaiViet1);

        // Lấy danh sách bài viết có phân trang
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiViet(pageable);
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        // Truyền thêm thông tin phân trang
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pageSize", pageSize);

        // Lấy danh sách album
        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);

        return "giang-vien/quan-ly-danh-sach-bai-viet";
    }

    @GetMapping("/danh-sach-bai-viet/{id}")
    public String chiTietBaiViet(@PathVariable("id") Integer id, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, Model model) {
        String role = "lecturer";
        model.addAttribute("role", role);

        model.addAttribute("pageNum", pageNum);

        // Lấy chi tiết bài viết theo ID
        BaiVietDTO baiViet = baiVietRepository.findBaiVietById(id);
        if (baiViet == null) {
            return "redirect:/error";
        }
        model.addAttribute("baiViet", baiViet);

        // Lấy danh sách album bài viết đã thuộc về
        List<Album> danhSachAlbumDaThuoc = albumRepository.findAlbumsByBaiVietId(id);
        model.addAttribute("danhSachAlbumDaThuoc", danhSachAlbumDaThuoc);

        // Lấy tất cả album để hiển thị trong modal
        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);

        return "giang-vien/quan-ly-chi-tiet-bai-viet";
    }

    @GetMapping("/danh-sach-bai-viet/tim-kiem")
    public String searchBaiViet(
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "tieuDe", required = false) String tieuDe,
            @RequestParam(value = "chuDe", required = false) String chuDe,
            @RequestParam(value = "dotVietBaiId", required = false) Integer dotVietBaiId,
            Model model) {

        String role = "lecturer";
        model.addAttribute("role", role);

        Pageable pageable = PageRequest.of(pageNum, pageSize);

        Page<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiVietByFilters1(pageable, tieuDe, chuDe, dotVietBaiId);
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        List<BaiVietDTO> danhSachBaiViet1 = baiVietRepository.findBaiVietByFilters(tieuDe, chuDe, dotVietBaiId);
        model.addAttribute("danhSachBaiViet1", danhSachBaiViet1);

        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);

        return "giang-vien/quan-ly-danh-sach-bai-viet";
    }
}
