package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import com.company.entity.Vehicle;
import org.springframework.stereotype.Repository;

/*
* 9. create this repository
* 10. add org.springframework.data spring-data-commons to pom.xml
*/
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
