package com.example.TTTN.controller.admin;

import com.example.TTTN.entity.DotDangKy;
import com.example.TTTN.entity.NguoiDung;
import com.example.TTTN.service.lmp.DotDangKyServiceIMPL;
import com.example.TTTN.service.lmp.NguoiDungServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class DotDangKiController {
    @Autowired
    DotDangKyServiceIMPL dotDangKyServiceIMPL;

    @Autowired
    NguoiDungServiceIMPL nguoiDungServiceIMPL;

    @GetMapping("/dot-dang-ky")
    public String ddk(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "4") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<DotDangKy> dotDangKyPage = dotDangKyServiceIMPL.getDotDangKyList(pageable);

        model.addAttribute("role", "admin"); // Truyền role xuống view
        model.addAttribute("list", dotDangKyPage.getContent()); // Danh sách đợt đăng ký theo trang
        model.addAttribute("currentPage", page); // Trang hiện tại
        model.addAttribute("totalPages", dotDangKyPage.getTotalPages()); // Tổng số trang

        return "/admin/quan-ly-dot-dang-ky"; // Đường dẫn đến view
    }

    @GetMapping("/dot-dang-ky/search")
    public String searchDotDangKy(
            @RequestParam(required = false, defaultValue = "", value = "ten") String ten,
            @RequestParam(required = false, defaultValue = "", value = "trangThai") String ma,
            @RequestParam(required = false, defaultValue = "", value = "trangThai") String trangThai,
            @RequestParam(required = false,value = "tuNgay") LocalDate tuNgay,
            @RequestParam(required = false, value = "denNgay") LocalDate denNgay,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            Model model
            ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<DotDangKy> dotDangKyPage;

        if (!ten.isEmpty() || !trangThai.isEmpty() || tuNgay != null || denNgay != null) {
            dotDangKyPage = dotDangKyServiceIMPL.searchByCriteria(ten,trangThai,tuNgay, denNgay, pageable);
        } else {
            dotDangKyPage = dotDangKyServiceIMPL.getDotDangKyList(pageable);
        }
        System.out.println(dotDangKyPage);
        model.addAttribute("role", "admin"); // Truyền role xuống view
        model.addAttribute("list", dotDangKyPage.getContent()); // Danh sách đợt đăng ký theo trang
        model.addAttribute("currentPage", page); // Trang hiện tại
        model.addAttribute("totalPages", dotDangKyPage.getTotalPages()); // Tổng số trang
        return "/admin/quan-ly-dot-dang-ky";
    }


    @RequestMapping(value = "/change-status",method = RequestMethod.POST)
    public String changeStatus(@RequestParam(value ="selectedIds",required = false) List<Integer> selectedIds ,@RequestParam("action") String action) {
        // Xử lý các mã đã được chọn
        if (selectedIds == null || selectedIds.isEmpty()) {
            // Thêm thông báo lỗi vào RedirectAttributes

            return "redirect:/admin/dot-dang-ky";
        }
        for (Integer id : selectedIds) {
            // Tìm đối tượng theo ID
            Optional<DotDangKy> dotDangKyOptional = Optional.ofNullable(dotDangKyServiceIMPL.getDotDangKyById(id));

            if (dotDangKyOptional.isPresent()) {
                DotDangKy dotDangKy = dotDangKyOptional.get();
                if ("activate".equals(action)) {
                    // Cập nhật trạng thái thành "Hoạt động"
                    dotDangKy.setTrangThai("Hoạt động");
                } else if ("deactivate".equals(action)) {
                    // Cập nhật trạng thái thành "Dừng hoạt động"
                    dotDangKy.setTrangThai("Dừng hoạt động");
                }
                // Lưu thực thể đã cập nhật
                dotDangKyServiceIMPL.saveOrUpdateDotDangKy(dotDangKy);
            }
        }
        return "redirect:/admin/dot-dang-ky";
    }

    @PostMapping("/dot-dang-ky/add")
    public String addDotDangKy(@RequestParam String ten,
                               @RequestParam String tuNgay,
                               @RequestParam String denNgay,
                               @RequestParam String ngayBatDauDang,
                               @RequestParam String ngayKetThucDang,
                               Model model) {
        // Chuyển đổi các chuỗi thành LocalDate
        LocalDate fromDate = LocalDate.parse(tuNgay);
        LocalDate toDate = LocalDate.parse(denNgay);
        LocalDate startDate = LocalDate.parse(ngayBatDauDang);
        LocalDate endDate = LocalDate.parse(ngayKetThucDang);

        // Tạo đối tượng DotDangKyDTO
        DotDangKy dotDangKy = new DotDangKy();
        dotDangKy.setTen(ten);
        dotDangKy.setNgayTao(fromDate);
        dotDangKy.setDenNgay(toDate);
        dotDangKy.setNgayBatDauDangKy(startDate);
        dotDangKy.setNgayKetThucDangKy(endDate);
        dotDangKy.setTrangThai("Hoạt động");

        // Gọi service để lưu thông tin đợt đăng ký (giả định bạn có một service để xử lý logic lưu trữ)
         dotDangKyServiceIMPL.saveOrUpdateDotDangKy(dotDangKy);

        // Thêm thông báo hoặc mô hình vào model nếu cần
        model.addAttribute("message", "Đợt đăng ký đã được thêm thành công!");

        // Quay lại trang danh sách hoặc trang khác
        return "redirect:/admin/dot-dang-ky"; // Điều hướng đến danh sách đợt đăng ký
    }

    @GetMapping("/phan-cong-chu-de/{id}")
    public String showPhanCongChuDe(@PathVariable Integer id, Model model) {
        DotDangKy dotDangKyDetail = dotDangKyServiceIMPL.getDotDangKyById(id);
        model.addAttribute("dotDangKyDetail", dotDangKyDetail);

        List<NguoiDung> listGianVienChuDe =nguoiDungServiceIMPL.getAllGiangVien();
        model.addAttribute("listGianVienChuDe", listGianVienChuDe);
        return "admin/phan-cong-chu-de";
    }

    @GetMapping("/back")
    public String back(Model model) {
        return "/admin/quan-ly-dot-dang-ky";
    }

    @GetMapping("/chi-tiet-dot-dang-ki/{id}")
    public String chiTietDot(@PathVariable Integer id, Model model){
        DotDangKy dotDangKyDetail = dotDangKyServiceIMPL.getDotDangKyById(id);
        model.addAttribute("dotDangKyDetail", dotDangKyDetail);

        return "/admin/chi-tiet-dot-dang-ki";
    }


}
