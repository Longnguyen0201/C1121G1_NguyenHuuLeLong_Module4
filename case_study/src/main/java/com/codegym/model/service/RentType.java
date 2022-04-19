package com.codegym.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;

    @Column(name = "rent_type_name")
    private Integer rentTypeName;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> Services;


}
