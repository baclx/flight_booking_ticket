package com.example.finalproject.service;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.VeMayBay;

import java.util.List;

public interface VeMayBayService extends GenericService<VeMayBay> {
    List<VeMayBay> findAll(TicketSearchDto searchDto);
}
