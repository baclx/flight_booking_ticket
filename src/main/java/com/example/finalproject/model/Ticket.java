package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long price;

    private String time; // thời gian bay

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
