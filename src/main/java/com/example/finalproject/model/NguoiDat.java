package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.*;

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

    @Column(name = "maDatVe")
    private Long maDV; // id ve may bay
}
