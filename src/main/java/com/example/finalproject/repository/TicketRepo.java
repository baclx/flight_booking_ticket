package com.example.finalproject.repository;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t JOIN t.flight f " +
            "WHERE (:#{#ticketSearchDto.dateFlight} IS NULL OR f.dateFlight = :#{#ticketSearchDto.dateFlight}) " +
            "AND (:#{#ticketSearchDto.fromFlight} IS NULL OR f.fromFlight = :#{#ticketSearchDto.fromFlight}) " +
            "AND (:#{#ticketSearchDto.toFlight} IS NULL OR f.toFlight = :#{#ticketSearchDto.toFlight})")
    List<Ticket> searchTicket(@Param("ticketSearchDto") TicketSearchDto dto);
}
