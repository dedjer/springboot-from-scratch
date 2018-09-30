package com.company.controller;

import com.company.model.Customer;
import com.company.model.Vehicle;
import com.company.repository.CustomerRepository;
import com.company.repository.VehicleRepository;
import com.company.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/customers")        //Add path for this controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    private VehicleRepository vehicleRepository;

    // Get All Customers in JSON
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    // Add a Customer
    @PostMapping(path="/add")
    Customer addCustomer(@RequestBody Customer c) {
        return customerRepository.save(c);
    }

    // Add a Customer Vehicle
//    @PostMapping(path="/{id}/vehicle/add")
//    Customer addVehicle(@RequestBody Vehicle v, @PathVariable long id) {
//
//        Customer c = new Customer();
//
//        try {
//
//
//            c.vehicles.add(v);
//
//
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//
//        return customerRepository.save(c);
//    }

}
