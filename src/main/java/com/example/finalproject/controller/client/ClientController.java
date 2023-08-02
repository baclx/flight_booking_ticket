package com.example.finalproject.controller.client;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.VeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private VeMayBayService veMayBayService;

    @GetMapping("/")
    public String index(@Param("search") TicketSearchDto search, Model model) {
        List<VeMayBay> veMayBayList = veMayBayService.findAll(search);
        model.addAttribute("searchDto", search);
        model.addAttribute("veMayBayList", veMayBayList);
        return "client/index";
    }

    @GetMapping("/form_order/{id}")
    public String formOrder(@PathVariable("id") Long maDV, Model model) {
        model.addAttribute("maDV", maDV);
        return "client/order_ticket";
    }
}
