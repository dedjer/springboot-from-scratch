package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.company.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
* 9. create this repository
* 10. add org.springframework.data spring-data-commons to pom.xml
*/
@CrossOrigin()
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
