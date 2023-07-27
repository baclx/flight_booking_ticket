package com.example.finalproject.service;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.Ticket;

import java.util.List;

public interface TicketService extends GenericService<Ticket> {
    List<Ticket> findAll(TicketSearchDto searchDto);
}
