package com.example.finalproject.controller.admin;

import com.example.finalproject.model.Flight;
import com.example.finalproject.model.Ticket;
import com.example.finalproject.service.FlightService;
import com.example.finalproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightService flightService;

    @GetMapping
    public String index(Model model) {

        List<Ticket> ticketList = ticketService.findAll();

        model.addAttribute("title", "Quản lý vé máy bay");
        model.addAttribute("ticketList", ticketList);

        return "admin/ticket/index";
    }

    @GetMapping("/add")
    public String add(Model model) {

        List<Flight> flightList = flightService.findAll();

        model.addAttribute("title", "Tạo vé");
        model.addAttribute("flightList", flightList);

        return "admin/ticket/create";
    }

    @PostMapping("/create")
    public String create(Ticket ticket) {

        ticketService.save(ticket);

        return "redirect:/admin/ticket";
    }
}
