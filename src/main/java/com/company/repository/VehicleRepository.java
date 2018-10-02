package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.company.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
* 9. create this repository
* 10. add org.springframework.data spring-data-commons to pom.xml
*/
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
