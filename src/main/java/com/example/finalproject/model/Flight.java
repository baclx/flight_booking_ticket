package com.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameFlight; // tên chuyến bay

    private String nameManufacturer; // hãng chuyến bay

    private String dateFlight; // ngày bay

    private Integer numberOfSeats; // số lượng ghế

    private String description;

    private String fromFlight;

    private String toFlight;

    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<Ticket> ticketList;
}
