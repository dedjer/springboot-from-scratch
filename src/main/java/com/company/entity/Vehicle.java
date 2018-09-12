package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
* 7. created this class
* 8. annotated @entity, @id, and @column
* WHen do you
*/

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable {

    @Id
    @Column(name="vehicle_id")
    @GeneratedValue
    private int id;

    @Column(name="make")
    private String make;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
