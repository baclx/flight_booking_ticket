package com.example.finalproject.dto;

import lombok.Data;

@Data
public class TicketSearchDto {
    private String dateFlight; // ngày bay

    private String fromFlight;

    private String toFlight;
}
