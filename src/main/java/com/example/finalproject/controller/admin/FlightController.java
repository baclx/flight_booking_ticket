package com.example.finalproject.controller.admin;

import com.example.finalproject.model.Flight;
import com.example.finalproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public String index(Model model) {
        List<Flight> flightList = flightService.findAll();

        model.addAttribute("title", "Quản lý chuyến bay");
        model.addAttribute("flightList", flightList);

        return "admin/flight/index";
    }
}
