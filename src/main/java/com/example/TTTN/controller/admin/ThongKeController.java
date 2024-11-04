package com.example.TTTN.controller.admin;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.service.BaiVietService;
import com.example.TTTN.service.DotDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("admin/thong-ke")
public class ThongKeController {

    @Autowired
    BaiVietService baiVietService;

    @Autowired
    BaiVietRepository baiVietRepository;


    @Autowired
    DotDangKyService dotDangKyService;

    @GetMapping("/thong-ke-bai-viet")
    public String thongKeBaiViet(Model model,
                                 @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                 @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        String role = "admin";
        model.addAttribute("role", role);

        // Lấy thống kê số lượng bài viết theo từng trạng thái
        long soLuongBaiVietDaDang = baiVietService.countByStatus("Đã đăng", startDate, endDate);
        long soLuongBaiVietKhongDang = baiVietService.countByStatus("Không đăng", startDate, endDate);
        long soLuongBaiVietGuiPR = baiVietService.countByStatus("Đang xử lý", startDate, endDate);
        long soLuongBaiVietPheDuyet = baiVietService.countByStatus("Đã phê duyệt", startDate, endDate);
        long soLuongBaiVietTuChoi = baiVietService.countByStatus("Đã từ chối", startDate, endDate);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển đổi từ Date sang String
        String formattedStartDate = "", formattedEndDate ="";
        if (startDate != null) {
            formattedStartDate = formatter.format(startDate);
        }
        if (endDate != null) {
            formattedEndDate = formatter.format(endDate);
        }
        model.addAttribute("startDate", formattedStartDate);
        model.addAttribute("endDate", formattedEndDate);

        model.addAttribute("soLuongBaiVietDaDang", soLuongBaiVietDaDang);
        model.addAttribute("soLuongBaiVietKhongDang", soLuongBaiVietKhongDang);
        model.addAttribute("soLuongBaiVietGuiPR", soLuongBaiVietGuiPR);
        model.addAttribute("soLuongBaiVietPheDuyet", soLuongBaiVietPheDuyet);
        model.addAttribute("soLuongBaiVietTuChoi", soLuongBaiVietTuChoi);

        return "/admin/thong-ke/thong-ke-bai-viet";
    }

    @GetMapping("/thong-ke-giang-vien")
    public String thongKeGiangVien(Model model,
                                   @RequestParam(required = false) Optional<Integer> pN,
                                   @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                   @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        String role = "admin";
        model.addAttribute("role", role);

        // Lấy danh sách giảng viên và số lượng bài viết
        Page<Object[]> danhSachGiangVienThongKe = baiVietService.thongKeGiangVien(startDate, endDate, PageRequest.of(pN.orElse(0), 3));

        model.addAttribute("danhSachGiangVienThongKe", danhSachGiangVienThongKe);

        return "/admin/thong-ke/thong-ke-giang-vien";
    }

    @GetMapping("/tim-kiem-bai-viet")
    public String timKiemBaiViet(Model model,
                                 @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                 @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                 @RequestParam(required = false) Optional<Integer> pN) {
        String role = "admin";
        model.addAttribute("role", role);
        System.out.println(startDate);
        System.out.println(endDate);

        Page<BaiViet> danhSachBaiViet = baiVietService.findByDateRange(startDate, endDate, PageRequest.of(pN.orElse(0),3));
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        return "/admin/thong-ke/tim-kiem-bai-viet";
    }
//    @GetMapping("/thong-ke-dot-dang-ky")
//    public String thongKeDotDangKy(Model model,
//                                   @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
//                                   @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
//        String role = "admin";
//        model.addAttribute("role", role);
//
//        List<Object[]> thongKeDotDangKy = dotDangKyService.thongKeDotDangKy(startDate, endDate);
//        model.addAttribute("thongKeDotDangKy", thongKeDotDangKy);
//
//        return "/admin/thong-ke-dot-dang-ky";
//    }

}
