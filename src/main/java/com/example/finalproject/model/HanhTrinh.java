package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "HanhTrinh")
public class HanhTrinh {
    @Id
    private String shChuyenBay;

    private Date thoiGianKhoiHanh;

    private Date thoiGianHaCanh;

    private String diemKhoiHanh;

    private String diemKetThuc;

    private Long maDatVe; // id ve may bay
}
