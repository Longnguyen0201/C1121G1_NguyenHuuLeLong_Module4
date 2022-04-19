package com.codegym.model.contract;



import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    @NotNull
    @Column(name = "start_date",columnDefinition = "date")
    private String contractStartDate;
    @NotNull
    @Column(name = "end_date",columnDefinition = "date")
    private String contractEndDate;

    @NotNull
    @Column(name = "contract_detail")
    private Double contractDeposit;
    @NotNull
    @Column(name = "contract_total_money")
    private Double contractTotalMoney;

   @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

   @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

}
