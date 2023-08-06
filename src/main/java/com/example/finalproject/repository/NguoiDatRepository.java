package com.example.finalproject.repository;

import com.example.finalproject.dto.TicketOrderedDto;
import com.example.finalproject.model.NguoiDat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NguoiDatRepository extends JpaRepository<NguoiDat, Long> {

    @Query("select new com.example.finalproject.dto.TicketOrderedDto(nd.sdt, nd.diaChi, nd.hoTen, u.username, u.email, vmb.diemKhoiHanh, vmb.diemKetThuc, vmb.soNgLon, vmb.soTreEm, " +
            "vmb.ngayDi, vmb.ngayVe, vmb.hangVe, vmb.ngayDangKy, vmb.soHieuChuyenBayDi, vmb.soHieuChuyenBayVe, vmb.price) " +
            "from User u " +
            "join NguoiDat nd on u.id = nd.idUser " +
            "join VeMayBay vmb on vmb.maDV = nd.maDV where 1 = 1")
    List<TicketOrderedDto> listTicketOrdered();

    @Query("select new com.example.finalproject.dto.TicketOrderedDto(nd.sdt, nd.diaChi, nd.hoTen, u.username, u.email, vmb.diemKhoiHanh, vmb.diemKetThuc, vmb.soNgLon, vmb.soTreEm, " +
            "vmb.ngayDi, vmb.ngayVe, vmb.hangVe, vmb.ngayDangKy, vmb.soHieuChuyenBayDi, vmb.soHieuChuyenBayVe, vmb.price) " +
            "from User u " +
            "join NguoiDat nd on u.id = nd.idUser " +
            "join VeMayBay vmb on vmb.maDV = nd.maDV where u.id = ?1")
    List<TicketOrderedDto> listTicketOrderedClient(Long id);
}
