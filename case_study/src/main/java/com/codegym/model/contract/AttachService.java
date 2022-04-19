package com.codegym.model.contract;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;
    @NotNull
    @Column(name = "attach_service_Name")
    private String attachServiceName;
    @NotNull
    @Column(name = "attach_service_cost")
    private Double attachServiceCost;
    @NotNull
    @Column(name = "attach_service_unit")
    private String attachServiceUnit;
    @Column(name = "attach_service_status")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;

}
