package com.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="fullname")
    private String name;

    //CascadType.ALL and orphanRemoval=true will delete the child addresses if the parent is deleted
    //This list address property is mapped by the Address.customer property
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

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

    //This will run when an AddressList is saved to the Customer.
    //Allows the client to PUT (add) an address to the customer and persists the change to the database
    //Thanks to https://reflectoring.io/relations-with-spring-data-rest/ for explaining bi-directional persistence
    @PrePersist
    @PreUpdate
    public void updateAddressAssociation(){
        for(Address address : this.addresses){
            address.setCustomer(this);
        }
    }

    /**
     *
     */
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "customer_vehicle",
////            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
//    )
//    @JsonBackReference
//    public Set<Vehicle> vehicles;
//
//    public Set<Vehicle> getVehicles() {
//        return vehicles;
//    }

//    public void setVehicles(Set<Vehicle> vehicles){
//        this.vehicles = vehicles;
//    }
}
