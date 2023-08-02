package com.example.finalproject.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "VeMayBay")
public class VeMayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDV;

    private String diemKhoiHanh;

    private String diemKetThuc;

    private Integer soNgLon;

    private Integer soTreEm;

    private Date ngayDi;

    private Date ngayVe;

    private String hangVe; // hạng vé

    private Date ngayDangKy;

    private String soHieuChuyenBayDi;

    private String soHieuChuyenBayVe;

    //
    private Long price;
}
