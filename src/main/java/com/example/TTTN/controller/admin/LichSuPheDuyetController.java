package com.example.TTTN.controller.admin;

import com.example.TTTN.entity.BaiViet;
import com.example.TTTN.entity.LichSuPheDuyet;
import com.example.TTTN.repository.BaiVietRepository;
import com.example.TTTN.repository.LichSuPheDuyetRepository;
import com.example.TTTN.service.BaiVietService;
import com.example.TTTN.service.LichSuPheDuyetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class LichSuPheDuyetController {

    @Autowired
    private LichSuPheDuyetService lichSuPheDuyetService;
    @Autowired
    private LichSuPheDuyetRepository lichSuPheDuyetRepository;
    @Autowired
    private BaiVietRepository baiVietRepository;
    @Autowired
    private BaiVietService baiVietService;

    @GetMapping("/lich-su-phe-duyet/page/{pN}")
    public String viewLichSuPheDuyet(Model model,
                                     @PathVariable Optional<Integer> pN,
                                     @RequestParam(value = "searchTitle", required = false) String searchTitle,
                                     @RequestParam(value = "status", required = false) String status,
                                     @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                     @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        String role = "admin"; //

        model.addAttribute("role", role);
        int pageNumber = pN.orElse(1) - 1;
        if (pageNumber == 0) {
            return "redirect:/admin/lich-su-phe-duyet";
        }
        PageRequest page = PageRequest.of(pageNumber, 3);

        if (status != null) {
            if (status.isEmpty()) {
                status = null;
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển đổi từ Date sang String
        String formattedStartDate = "", formattedEndDate ="";
        if (startDate != null) {
            formattedStartDate = formatter.format(startDate);
        }
        if (endDate != null) {
            formattedEndDate = formatter.format(endDate);
        }
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("status", status);
        model.addAttribute("startDate", formattedStartDate);
        model.addAttribute("endDate", formattedEndDate);
        model.addAttribute("listBV", baiVietService.searchArticles("%" + searchTitle + "%", status, startDate, endDate, page));
        return "/admin/quan-ly-lich-su-phe-duyet";
    }

    @GetMapping("/lich-su-phe-duyet")
    public String viewLichSuPheDuyetMacDinh(Model model,
                                            @RequestParam(value = "searchTitle", required = false) String searchTitle,
                                            @RequestParam(value = "status", required = false) String status,
                                            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        String role = "admin"; //
        model.addAttribute("role", role);
        PageRequest page = PageRequest.of(0, 3);
        if (status != null) {
            if (status.isEmpty()) {
                status = null;
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển đổi từ Date sang String
        String formattedStartDate = "", formattedEndDate ="";
        if (startDate != null) {
            formattedStartDate = formatter.format(startDate);
        }
        if (endDate != null) {
            formattedEndDate = formatter.format(endDate);
        }
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("status", status);
        model.addAttribute("startDate", formattedStartDate);
        model.addAttribute("endDate", formattedEndDate);
        if (searchTitle == null) {
            searchTitle = "";
        }
        model.addAttribute("listBV", baiVietService.searchArticles("%" + searchTitle + "%", status, startDate, endDate, page));

        return "/admin/quan-ly-lich-su-phe-duyet";
    }

    @GetMapping("/lich-su-phe-duyet/{baiVietId}")
    public String viewTheoBaiViet(Model model, @PathVariable Optional<Integer> baiVietId) {
        String role = "admin"; //
        model.addAttribute("role", role);
        model.addAttribute("baiViet", baiVietService.getBaiViet(baiVietId.orElse(0)));
        model.addAttribute("listLSPDCT", lichSuPheDuyetService.find(baiVietId.orElse(0)));
        System.out.println(lichSuPheDuyetService.find(baiVietId.orElse(0)));
        return "/admin/quan-ly-lich-su-phe-duyet-chi-tiet";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<LichSuPheDuyet> search(@RequestParam("query") Integer query) {
        System.out.println(lichSuPheDuyetService.find(query));
        return lichSuPheDuyetService.find(query);
    }
}
