package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTuyen;

    private String thanhPho1;

    private String thanhPho2;

    private Long maThanhPho; // id thanh pho
}
