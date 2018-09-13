package com.company.controller;

import com.company.repository.VehicleRepository;
import com.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.company.entity.Vehicle;

@RestController
@RequestMapping(path="/vehicle")        //Add path for this controller
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

    // Test saving a hardcoded vehicle to the database
    @GetMapping(path="/example")
    public String save() {
        vehicleService.saveVehicle();
        return ("Saved");
    }

    // Get All Vehicles in JSON
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Add a Vehicle
    @PostMapping(path="/add")
    Vehicle addVehicle(@RequestBody Vehicle v) {
        return vehicleRepository.save(v);
    }

    // Delete a Vehicle
    @DeleteMapping("/remove/{id}")
    void deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
    }
}
