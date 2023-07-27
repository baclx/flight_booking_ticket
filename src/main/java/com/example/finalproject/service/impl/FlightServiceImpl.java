package com.example.finalproject.service.impl;

import com.example.finalproject.model.Flight;
import com.example.finalproject.repository.FlightRepo;
import com.example.finalproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;

    @Override
    public List<Flight> findAll() {
        return flightRepo.findAll();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRepo.findById(id);
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepo.save(flight);
    }

    @Override
    public void remove(Long id) {
        flightRepo.deleteById(id);
    }
}
