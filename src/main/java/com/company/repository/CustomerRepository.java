package com.company.repository;

import com.company.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@Param needed to pull querystring parameter from REST request
    //Example REST Call: http://localhost:8080/customers/search/findByNameLike?name=cia
    //Search by Like not working correctly. Need to work on this. Might need to try Containing instead
    List<Customer> findByNameContaining(@Param("name")String name);

    List<Customer> findByAddressesStateEquals(@Param("state")String state);

    List<Customer> findByAddressesCityEquals(@Param("city")String city);

    //This corresponds to the object model and NOT the database table
    @Query("select c from Customer c where c.name = :name")
    List<Customer> queryByName(@Param("name")String name);

    List<Customer> findByVehiclesMakeLike(String make);
}
