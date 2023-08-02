package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GiaVe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maVe;

    private String hangBay; // hãng bay

    private Integer giaVe;

    private Long maTuyenBay; // id tuyen bay
}
