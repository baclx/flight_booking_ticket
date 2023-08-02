package com.example.finalproject.service.impl;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.repository.VeMayBayRepo;
import com.example.finalproject.service.VeMayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VeMayBayServiceImpl implements VeMayBayService {
    @Autowired
    private VeMayBayRepo veMayBayRepo;

    @Override
    public List<VeMayBay> findAll() {
        return veMayBayRepo.findAll();
    }

    @Override
    public Optional<VeMayBay> findById(Long id) {
        return veMayBayRepo.findById(id);
    }

    @Override
    public VeMayBay save(VeMayBay veMayBay) {
        return veMayBayRepo.save(veMayBay);
    }

    @Override
    public void remove(Long id) {
        veMayBayRepo.deleteById(id);
    }

    @Override
    public List<VeMayBay> findAll(TicketSearchDto searchDto) {
        if (searchDto.getDateFlight() != null || searchDto.getFromFlight() != null || searchDto.getToFlight() != null) {
            Date dateFlight = null;
            if (searchDto.getDateFlight().equals("")) {
                searchDto.setDateFlight(null);
            } else {
                dateFlight = Date.valueOf(searchDto.getDateFlight());
            }
            if (searchDto.getFromFlight().equals("")) {
                searchDto.setFromFlight(null);
            }
            if (searchDto.getToFlight().equals("")) {
                searchDto.setToFlight(null);
            }
            return veMayBayRepo.timKiemVeMayBay(searchDto, dateFlight);
        }
        return veMayBayRepo.findAll();
    }
}
