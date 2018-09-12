package com.company.component;

import com.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* This class was only created to test my project because you can't use annotations inside the static main method.
 */
@Component
public class VehicleRunner implements CommandLineRunner {
    @Autowired
    private VehicleService vehicleService;

    @Override
    public void run(String...args) throws Exception {
        vehicleService.saveVehicle();

    }
}