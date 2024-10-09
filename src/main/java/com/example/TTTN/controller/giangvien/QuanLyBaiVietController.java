package com.example.TTTN.controller.giangvien;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.Album;
import com.example.TTTN.entity.AlbumBaiViet;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.repository.AlbumBaiVietRepository;
import com.example.TTTN.repository.AlbumRepository;
import com.example.TTTN.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/giang-vien")
public class QuanLyBaiVietController {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumBaiVietRepository albumBaiVietRepository;

    @GetMapping("/danh-sach-bai-viet")
    public String listBaiViet(Model model) {
        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view
        // Lấy danh sách bài viết từ repository
        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiViet();
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);
        // Trả về view để hiển thị danh sách bài viết
        return "giang-vien/quan-ly-danh-sach-bai-viet";
    }

    @GetMapping("/danh-sach-bai-viet/{id}")
    public String chiTietBaiViet(@PathVariable("id") Integer id, Model model) {
        String role = "lecturer";
        model.addAttribute("role", role);

        // Lấy chi tiết bài viết từ repository
        BaiVietDTO baiViet = baiVietRepository.findBaiVietById(id);
        if (baiViet == null) {
            return "redirect:/error";
        }

        // Lấy danh sách album mà bài viết đã thuộc về
        List<Album> danhSachAlbumDaThuoc = albumRepository.findAlbumsByBaiVietId(id);
        model.addAttribute("baiViet", baiViet);
        model.addAttribute("danhSachAlbumDaThuoc", danhSachAlbumDaThuoc); // Truyền danh sách album bài viết đã thuộc về

        // Lấy tất cả album để hiển thị trong modal
        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);

        return "giang-vien/quan-ly-danh-sach-bai-viet";
    }



    @GetMapping("/danh-sach-bai-viet/tim-kiem")
    public String searchBaiViet(
            @RequestParam(value = "tieuDe", required = false) String tieuDe,
            @RequestParam(value = "chuDe", required = false) String chuDe,
            @RequestParam(value = "dotVietBaiId", required = false) Integer dotVietBaiId,
            Model model) {

        String role = "lecturer"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role); // Truyền role xuống view

        // Lấy danh sách bài viết từ repository với các bộ lọc

        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.findBaiVietByFilters(tieuDe, chuDe, dotVietBaiId);
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        List<Album> danhSachAlbum = albumRepository.findAll();
        model.addAttribute("danhSachAlbum", danhSachAlbum);

        return "giang-vien/quan-ly-danh-sach-bai-viet"; // Tên của template chi tiết
    }

//    @PostMapping("/danh-sach-bai-viet/luu-album-bai-viet")
//    public String luuAlbumBaiViet(@RequestParam Integer baiVietId, @RequestParam List<Integer> albumIds) {
//        // Tìm bài viết theo ID
//        BaiViet baiViet = baiVietRepository.findById(baiVietId).orElse(null);
//
//        if (baiViet != null) {
//            for (Integer albumId : albumIds) {
//                // Tìm album theo ID
//                Album album = albumRepository.findById(albumId).orElse(null);
//
//                if (album != null) {
//                    // Kiểm tra xem bản ghi đã tồn tại hay chưa
//                    Optional<AlbumBaiViet> existingRecord = albumBaiVietRepository.findByAlbumAndBaiViet(album, baiViet);
//
//                    if (existingRecord.isEmpty()) {
//                        // Tạo đối tượng AlbumBaiViet và lưu vào bảng trung gian
//                        AlbumBaiViet albumBaiViet = new AlbumBaiViet();
//                        albumBaiViet.setBaiViet(baiViet);
//                        albumBaiViet.setAlbum(album);
//                        albumBaiViet.setTrangThai("Đang hoạt động");  // Trang thái tùy chỉnh
//                        albumBaiViet.setCreatedAt(LocalDateTime.now());
//                        albumBaiViet.setUpdatedAt(LocalDateTime.now());
//
//                        albumBaiVietRepository.save(albumBaiViet);
//                    }
//                }
//            }
//        }
//        return "redirect:/giang-vien/danh-sach-bai-viet";
//    }


}
