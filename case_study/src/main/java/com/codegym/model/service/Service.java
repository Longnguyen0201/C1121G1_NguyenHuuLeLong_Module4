package com.codegym.model.service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "service_code",unique = true)
    private String serviceCode;
    @NotNull
    @Column(name = "service_name")
    private Integer serviceName;
    @Column(name = "service_area")
    private Integer serviceArea;
    @NotNull
    @Column(name = "service_cost")
    private Double serviceCost;
    @Column(name = "service_max_people")
    private Double serviceMaxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other")
    private String descriptionOther;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;


}
