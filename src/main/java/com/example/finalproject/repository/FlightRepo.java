package com.example.finalproject.repository;

import com.example.finalproject.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Long> {
}
