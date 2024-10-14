package com.example.TTTN.controller.giangvien;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.dto.DotVietBaiCuaToiDTO;
import com.example.TTTN.entity.Album;
import com.example.TTTN.repository.AlbumRepository;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.DotVietBaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/giang-vien")
public class BaiVietCuaToiController {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private DotVietBaiRepository dotVietBaiRepository;

    @GetMapping("/bai-viet-cua-toi")
    public String listBaiViet(Model model, @RequestParam(value = "id", defaultValue = "2") Integer id,
                              @RequestParam(value = "trangThai", required = false) String trangThai) {
        String role = "lecturer";
        model.addAttribute("role", role);

        addBaiVietAttributes(model, id);

        if (trangThai != null && trangThai.isEmpty()) {
            trangThai = null;
        }

        List<BaiVietDTO> baiVietYeuThich = baiVietRepository.baiVietCuaToiYeuThich(id);
        model.addAttribute("baiVietYeuThich", baiVietYeuThich);

        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.baiVietCuaToiTrangThai(id, trangThai);
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        List<DotVietBaiCuaToiDTO> danhSachDotBaiViet =dotVietBaiRepository.dotVietBaiCuaToi(id, "Đang mở");
        model.addAttribute("danhSachDotBaiViet", danhSachDotBaiViet);

        return "giang-vien/quan-ly-bai-viet-cua-toi";
    }

    @GetMapping("/bai-viet-cua-toi/loc")
    public String listBaiVietTrangThai(@RequestParam(value = "id", defaultValue = "2") Integer id,
                                       @RequestParam(value = "trangThai", required = false) String trangThai,
                                       Model model) {
        model.addAttribute("id", id); // Thêm giá trị id vào model
        model.addAttribute("trangThai", trangThai); // Thêm giá trị id vào model
        // Các xử lý khác
        String role = "lecturer";
        model.addAttribute("role", role);

        Long tongBaiViet = baiVietRepository.tongBaiViet(id);
        model.addAttribute("tongBaiViet", tongBaiViet);

        Long baiVietTuChoi = baiVietRepository.baiVietTrangThai(id, "Từ chối");
        model.addAttribute("baiVietTuChoi", baiVietTuChoi);

        Long baiVietDaDang = baiVietRepository.baiVietTrangThai(id, "Đã đăng");
        model.addAttribute("baiVietDaDang", baiVietDaDang);

        Long baiVietDangXuLy = baiVietRepository.baiVietTrangThai(id, "Đang xử lý");
        model.addAttribute("baiVietDangXuLy", baiVietDangXuLy);

        Long baiVietKhongDang = baiVietRepository.baiVietTrangThai(id, "Không đăng");
        model.addAttribute("baiVietKhongDang", baiVietKhongDang);

        Long baiVietDaPheDuyet = baiVietRepository.baiVietTrangThai(id, "Đã phê duyệt");
        model.addAttribute("baiVietDaPheDuyet", baiVietDaPheDuyet);

        if (trangThai != null && trangThai.isEmpty()) {
            trangThai = null;
        }

        List<BaiVietDTO> baiVietYeuThich = baiVietRepository.baiVietCuaToiYeuThich(id);
        model.addAttribute("baiVietYeuThich", baiVietYeuThich);

        // Lấy danh sách bài viết theo trạng thái
        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.baiVietCuaToiTrangThai(id, trangThai);

        // Thêm dữ liệu vào model để Thymeleaf có thể sử dụng
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        List<DotVietBaiCuaToiDTO> danhSachDotBaiViet =dotVietBaiRepository.dotVietBaiCuaToi(id, "Đang mở");
        model.addAttribute("danhSachDotBaiViet", danhSachDotBaiViet);

        return "giang-vien/quan-ly-bai-viet-cua-toi";
    }

    @GetMapping("/bai-viet-cua-toi/loc/{idbv}")
    public String viewBaiViet(@PathVariable Integer idbv,@RequestParam(value = "id", defaultValue = "2") Integer id,@RequestParam(value = "trangThai", required = false) String trangThai, Model model) {
        model.addAttribute("id", id); // Thêm giá trị id vào model
        model.addAttribute("trangThai", trangThai); // Thêm giá trị id vào model
        // Các xử lý khác
        String role = "lecturer";
        model.addAttribute("role", role);

        Long tongBaiViet = baiVietRepository.tongBaiViet(id);
        model.addAttribute("tongBaiViet", tongBaiViet);

        Long baiVietTuChoi = baiVietRepository.baiVietTrangThai(id, "Từ chối");
        model.addAttribute("baiVietTuChoi", baiVietTuChoi);

        Long baiVietDaDang = baiVietRepository.baiVietTrangThai(id, "Đã đăng");
        model.addAttribute("baiVietDaDang", baiVietDaDang);

        Long baiVietDangXuLy = baiVietRepository.baiVietTrangThai(id, "Đang xử lý");
        model.addAttribute("baiVietDangXuLy", baiVietDangXuLy);

        Long baiVietKhongDang = baiVietRepository.baiVietTrangThai(id, "Không đăng");
        model.addAttribute("baiVietKhongDang", baiVietKhongDang);

        Long baiVietDaPheDuyet = baiVietRepository.baiVietTrangThai(id, "Đã phê duyệt");
        model.addAttribute("baiVietDaPheDuyet", baiVietDaPheDuyet);

        if (trangThai != null && trangThai.isEmpty()) {
            trangThai = null;
        }

        List<BaiVietDTO> baiVietYeuThich = baiVietRepository.baiVietCuaToiYeuThich(id);
        model.addAttribute("baiVietYeuThich", baiVietYeuThich);
        // Lấy danh sách bài viết theo trạng thái
        List<BaiVietDTO> danhSachBaiViet = baiVietRepository.baiVietCuaToiTrangThai(id, trangThai);

        // Thêm dữ liệu vào model để Thymeleaf có thể sử dụng
        model.addAttribute("danhSachBaiViet", danhSachBaiViet);

        BaiVietDTO baiViet = baiVietRepository.findBaiVietById(idbv);
        if (baiViet == null) {
            return "redirect:/error"; // Xử lý trường hợp bài viết không tồn tại
        }

        model.addAttribute("baiViet", baiViet);

        List<DotVietBaiCuaToiDTO> danhSachDotBaiViet =dotVietBaiRepository.dotVietBaiCuaToi(id, "Đang mở");
        model.addAttribute("danhSachDotBaiViet", danhSachDotBaiViet);

        // Thêm thông tin khác vào model nếu cần
        return "giang-vien/quan-ly-bai-viet-cua-toi"; // Trả về cùng một view
    }

    private void addBaiVietAttributes(Model model, Integer id) {
        Long tongBaiViet = baiVietRepository.tongBaiViet(id);
        model.addAttribute("tongBaiViet", tongBaiViet);

        Long baiVietTuChoi = baiVietRepository.baiVietTrangThai(id, "Từ chối");
        model.addAttribute("baiVietTuChoi", baiVietTuChoi);

        Long baiVietDaDang = baiVietRepository.baiVietTrangThai(id, "Đã đăng");
        model.addAttribute("baiVietDaDang", baiVietDaDang);

        Long baiVietDangXuLy = baiVietRepository.baiVietTrangThai(id, "Đang xử lý");
        model.addAttribute("baiVietDangXuLy", baiVietDangXuLy);

        Long baiVietKhongDang = baiVietRepository.baiVietTrangThai(id, "Không đăng");
        model.addAttribute("baiVietKhongDang", baiVietKhongDang);

        Long baiVietDaPheDuyet = baiVietRepository.baiVietTrangThai(id, "Đã phê duyệt");
        model.addAttribute("baiVietDaPheDuyet", baiVietDaPheDuyet);
    }


}
