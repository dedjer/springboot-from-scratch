package com.company.repository;

import com.company.model.Customer;
import org.springframework.data.repository.CrudRepository;
import com.company.model.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
