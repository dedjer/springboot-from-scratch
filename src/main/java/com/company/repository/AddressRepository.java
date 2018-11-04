package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource; // Requires Maven repository spring-boot-starter-data-rest repo
import com.company.model.Address;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
//@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
}
