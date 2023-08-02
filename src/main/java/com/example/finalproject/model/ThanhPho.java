package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTP;

    private String tenTP;

    private Long maDatVe; // id ve may bay
}
