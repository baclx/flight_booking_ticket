package com.example.finalproject.repository;

import com.example.finalproject.dto.TicketSearchDto;
import com.example.finalproject.model.VeMayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface VeMayBayRepo extends JpaRepository<VeMayBay, Long> {
    @Query("select v from VeMayBay v " +
            "where (:#{#ticketSearchDto.fromFlight} is null or v.diemKhoiHanh = :#{#ticketSearchDto.fromFlight})" +
            "and (:#{#ticketSearchDto.toFlight} is null or v.diemKetThuc = :#{#ticketSearchDto.toFlight})" +
            "and (:dateFlight is null or v.ngayDangKy = :dateFlight)")
    List<VeMayBay> timKiemVeMayBay(@Param("ticketSearchDto") TicketSearchDto ticketSearchDto, @Param("dateFlight") Date dateFlight);
}
