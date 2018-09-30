package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
* 7. created this class
* 8. annotated @model, @id, and @column
* WHen do you
*/

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable {

    @Id
    @Column(name="vehicle_id")
    @GeneratedValue
    private long id;

    @Column(name="make")
    private String make;

//    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.LAZY)
//    private Set<Customer> customers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

/*
 * The @JsonManagedReference annotation removed an infinite recursion because
 * I have a many to many relationship between customer and vehicle
*/
//    @JsonManagedReference
//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;®
//    }
}
