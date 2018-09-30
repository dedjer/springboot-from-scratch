package com.company.service;

import com.company.model.Vehicle;
import com.company.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public void saveVehicle() {
        Vehicle v = new Vehicle();

        v.setMake("Hummer");

        vehicleRepository.save(v);
    }
}
