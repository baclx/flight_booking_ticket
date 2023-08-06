package com.example.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date; // vai~ util date mới map đc

@Data
@AllArgsConstructor
public class TicketOrderedDto {
    // thông tin đặt
    private String sdt;
    private String diaChi;
    private String hoTen;

    // thông tin khách
    private String username;
    private String email;

    // thông tin vé
    private String diemKhoiHanh;
    private String diemKetThuc;
    private Integer soNgLon;
    private Integer soTreEm;

    @Temporal(TemporalType.DATE)
    private Date ngayDi;
    private Date ngayVe;
    private String hangVe; // hạng vé
    private Date ngayDangKy;
    private String soHieuChuyenBayDi;
    private String soHieuChuyenBayVe;
    private Long price;
}
