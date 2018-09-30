package com.company.controller;

import com.company.repository.VehicleRepository;
import com.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.company.model.Vehicle;

@RestController
@RequestMapping(path="/vehicles")        //Add path for this controller
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
    @DeleteMapping(path="/remove/{id}")
    void deleteVehicle(@PathVariable long id) {
        vehicleRepository.deleteById(id);
    }

    // Get Vehicle
    @GetMapping(path="/{id}")
    public @ResponseBody Vehicle getVehicle(@PathVariable long id) {
        return vehicleRepository.findById(id).get();
    }
}
