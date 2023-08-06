package com.example.finalproject.controller.admin;

import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.VeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model,
            RedirectAttributes ra
    ) {
        Optional<VeMayBay> optionalVeMayBay = veMayBayService.findById(id);

        if (optionalVeMayBay.isPresent()) {
            model.addAttribute("veMayBay", optionalVeMayBay);
            model.addAttribute("title", "Edit Vé Máy Bay");
            return "admin/ticket/edit";
        }

        ra.addFlashAttribute("err", "Not Found");
        return "redirect:/admin/ve-may-bay";
    }

    @PostMapping("update")
    public String update(
            VeMayBay veMayBay,
            RedirectAttributes ra
    ) {
        veMayBayService.save(veMayBay);

        ra.addFlashAttribute("msg", "Update Success");

        return "redirect:/admin/ve-may-bay";
    }

    @GetMapping("delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            RedirectAttributes ra
    ) {
        veMayBayService.remove(id);
        ra.addFlashAttribute("msg", "Delete Success");

        return "redirect:/admin/ve-may-bay";
    }
}
