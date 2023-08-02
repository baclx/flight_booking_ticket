//package com.example.finalproject.service.impl;
//
//import com.example.finalproject.dto.TicketSearchDto;
//import com.example.finalproject.model.Ticket;
//import com.example.finalproject.repository.TicketRepo;
//import com.example.finalproject.service.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TicketServiceImpl implements TicketService {
//    @Autowired
//    private TicketRepo ticketRepo;
//
//    @Override
//    public List<Ticket> findAll() {
//        return ticketRepo.findAll();
//    }
//
//    @Override
//    public Optional<Ticket> findById(Long id) {
//        return ticketRepo.findById(id);
//    }
//
//    @Override
//    public Ticket save(Ticket ticket) {
//        return ticketRepo.save(ticket);
//    }
//
//    @Override
//    public void remove(Long id) {
//        ticketRepo.deleteById(id);
//    }
//
////    @Override
////    public List<Ticket> findAll(TicketSearchDto searchDto) {
////        if (searchDto.getDateFlight() != null || searchDto.getFromFlight() != null || searchDto.getToFlight() != null) {
////            if (searchDto.getDateFlight().equals("")) {
////                searchDto.setDateFlight(null);
////            } else {
////                String inputDate = searchDto.getDateFlight();
////                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////                LocalDate date = LocalDate.parse(inputDate, inputFormat);
////                String formattedDate = outputFormat.format(date);
////                searchDto.setDateFlight(formattedDate);
////            }
////            if (searchDto.getFromFlight().equals("")) {
////                searchDto.setFromFlight(null);
////            }
////            if (searchDto.getToFlight().equals("")) {
////                searchDto.setToFlight(null);
////            }
////
////            return ticketRepo.searchTicket(searchDto);
////        }
////        return ticketRepo.findAll();
////    }
//}
