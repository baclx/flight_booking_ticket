package com.example.finalproject.controller.client;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.Ticket;
import com.example.finalproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public List<Ticket> search(@RequestBody TicketSearchDto searchDto) {

        return ticketService.findAll(searchDto);
    }
}
