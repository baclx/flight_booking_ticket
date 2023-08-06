package com.example.finalproject.controller.client;

import com.example.finalproject.dto.TicketOrderedDto;
import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.NguoiDat;
import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.NguoiDatService;
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

    @Autowired
    private NguoiDatService nguoiDatService;

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

    @GetMapping("ticket_ordered")
    public String ticketOrdered(Model model) {

        List<TicketOrderedDto> ticketOrderedDtoList = nguoiDatService.listTicketOrderedClient();

        model.addAttribute("ticketOrderedDtoList", ticketOrderedDtoList);

        return "client/ticket_ordered";
    }
}
