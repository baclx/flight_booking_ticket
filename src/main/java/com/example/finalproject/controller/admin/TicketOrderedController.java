package com.example.finalproject.controller.admin;

import com.example.finalproject.dto.TicketOrderedDto;
import com.example.finalproject.service.NguoiDatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/ticket_ordered")
public class TicketOrderedController {
    @Autowired
    private NguoiDatService nguoiDatService;

    @GetMapping
    public String index(Model model) {
        List<TicketOrderedDto> ticketOrderedDtoList = nguoiDatService.listTicketOrderedAdmin();

        model.addAttribute("title", "Quản lý vé khách hàng đã đặt");
        model.addAttribute("ticketOrderedDtoList", ticketOrderedDtoList);

        return "admin/ticket_ordered/index";
    }
}
