package com.example.finalproject.controller.admin;

import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.VeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/ve-may-bay")
public class VeMayBayController {
    @Autowired
    private VeMayBayService veMayBayService;

    @GetMapping
    public String index(Model model) {
        List<VeMayBay> veMayBayList = veMayBayService.findAll();

        model.addAttribute("title", "Quản lý vé máy bay");
        model.addAttribute("veMayBayList", veMayBayList);

        return "admin/ticket/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Tạo vé");
        return "admin/ticket/create";
    }

    @PostMapping("/create")
    public String save(VeMayBay veMayBay) {
        veMayBayService.save(veMayBay);
        return "redirect:/admin/ve-may-bay";
    }
}
