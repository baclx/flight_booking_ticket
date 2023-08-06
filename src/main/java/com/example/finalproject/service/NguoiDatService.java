package com.example.finalproject.service;

import com.example.finalproject.dto.TicketOrderedDto;
import com.example.finalproject.model.NguoiDat;

import java.util.List;

public interface NguoiDatService extends GenericService<NguoiDat> {
    List<TicketOrderedDto> listTicketOrderedAdmin();
    List<TicketOrderedDto> listTicketOrderedClient();
}
