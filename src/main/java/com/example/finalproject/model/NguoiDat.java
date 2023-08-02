package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class NguoiDat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNgDat;

    private String sdt;

    private String diaChi;

    private String hoTen;

    private Long idUser; // id khach hang

    private Long maDatVe; // id ve may bay
}
