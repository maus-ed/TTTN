package com.example.TTTN.controller.nhanvienpr;

import com.example.TTTN.dto.BaiVietDTO;
import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.BaiVietCusTomer;
import com.example.TTTN.entity.ChuDe;
import com.example.TTTN.entity.DotVietBai;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.service.lmp.BaiVietServiceIMPL;
import com.example.TTTN.service.lmp.ChuDeServiceIMPL;
import com.example.TTTN.service.lmp.DotVietBaiServiceIMPL;
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
@RequestMapping("/nhan-vien-pr/quan-ly-danh-sach-bai-viet-pr")
public class DanhSachBaiVietController {

    @Autowired
    private BaiVietServiceIMPL baiVietServiceIMPL;

    @Autowired
    private ChuDeServiceIMPL chuDeServiceIMPL;

    @Autowired
    private DotVietBaiServiceIMPL dotVietBaiServiceIMPL;

    @Autowired
    private BaiVietRepository bvRepo;

//    @GetMapping()
//    public String getForm(Model model
//    ) {
//        String role = "pr-staff"; // Hoặc lấy giá trị role từ session hoặc service
//        model.addAttribute("role", role);
//
//        List<ChuDe> chuDeList = chuDeServiceIMPL.getAll();
//        model.addAttribute("chuDeList", chuDeList);
//
//        List<DotVietBai> dotVietBaiList = dotVietBaiServiceIMPL.getAll();
//        model.addAttribute("dotVietBaiList", dotVietBaiList);
//
//        return "/nhan-vien-pr/quan-ly-danh-sach-bai-viet";
//    }

    @GetMapping()
    public String getAll(Model model,
                         @RequestParam(name = "key", required = false) String key,
                         @RequestParam(name = "idChuDe", required = false) Integer idChuDe,
                         @RequestParam(name = "trangThai", required = false) String trangThai,
                         @RequestParam(name = "idDotVietBai", required = false) Integer idDotVietBai,
                         @RequestParam(defaultValue = "0") int page

    ) {
        String role = "pr-staff"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role);
        model.addAttribute("key", key);
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("idChuDe", idChuDe);
        model.addAttribute("idDotVietBai", idDotVietBai);
        Pageable pageable = PageRequest.of(page, 2);
        Page<BaiVietCusTomer> itemPage = baiVietServiceIMPL.search(key, idChuDe, trangThai, idDotVietBai, pageable);
        model.addAttribute("itemPage", itemPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", itemPage.getTotalPages());

        List<ChuDe> chuDeList = chuDeServiceIMPL.getAll();
        model.addAttribute("chuDeList", chuDeList);

        List<DotVietBai> dotVietBaiList = dotVietBaiServiceIMPL.getAll();
        model.addAttribute("dotVietBaiList", dotVietBaiList);


        return "/nhan-vien-pr/quan-ly-danh-sach-bai-viet";
    }

    @GetMapping("see-content/{id}")
    public String seeContent(Model model, @PathVariable Integer id){
        String role = "pr-staff"; // Hoặc lấy giá trị role từ session hoặc service
        model.addAttribute("role", role);
        model.addAttribute("baiviet", bvRepo.getReferenceById(id));

        return "/nhan-vien-pr/xem-noi-dung-bai-viet";
    }

}
