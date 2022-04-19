package com.codegym.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    @Column(name = "service_type_name")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

}
