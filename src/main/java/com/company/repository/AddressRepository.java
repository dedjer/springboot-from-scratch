package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; // Requires Maven repository spring-boot-starter-data-rest repo
import com.company.model.Address;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource
public interface AddressRepository extends CrudRepository<Address, Long> {
}
