package com.company.controller;

import com.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/example")
    public String example() {
        vehicleService.saveVehicle();

        return ("Saved");
    }
}
