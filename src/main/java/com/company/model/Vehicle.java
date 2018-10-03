package com.company.model;

import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @Column(name="make")
    private String make;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Customer> customers = new HashSet<>();

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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void setCustomer(Customer customer){
        this.customers.add(customer);
    }
}
