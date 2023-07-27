package com.example.finalproject.controller.client;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.Ticket;
import com.example.finalproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String index(@Param("search") TicketSearchDto search, Model model) {
        List<Ticket> ticketList = ticketService.findAll(search);
        model.addAttribute("searchDto", search);
        model.addAttribute("ticketList", ticketList);
        return "client/index";
    }
}
