package com.company.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    // Auto Increment ID doesn't seem to work correctly with MySql
    // /src/resource/data.sql seeds data with IDs, but if you go to Postman and try to insert a row with no ID
    // it attempts to use id "1" which is already taken.  I found this artical that tells JPA to use the native
    // ID generator: https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name="fullname")
    private String name;

    //CascadType.ALL and orphanRemoval=true will delete the child addresses if the parent is deleted
    //This list address property is mapped by the Address.customer property
    //UPDATE: 10/2/2018 Had to remove "orphanRemoval=true" because it prevented me from creating associations
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "customer_vehicle",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>();

    public Long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address a) {
        this.addresses.add(a);
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    //This will run when an AddressList is saved to the Customer.
    //Allows the client to PUT (add) an address to the customer and persists the change to the database
    //Thanks to https://reflectoring.io/relations-with-spring-data-rest/ for explaining bi-directional persistence
    @PrePersist
    @PreUpdate
    public void updateAssociation(){
        for(Address address : this.addresses){
            address.setCustomer(this);
        }
        for(Vehicle vehicle : this.vehicles){
            vehicle.setCustomer(this);
        }
    }

}
