package com.codegym.model.employee;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @NotNull
    @Column(name = "employee_name")
    private String employeeName;

    @NotNull
    @Column(name = "employee_birthday",columnDefinition = "date")
    private String employeeBirthday;

    @NotNull
    @Column(name = "employee_id_card")
    private String employeeIdCard;

    @NotNull
    @Column(name = "employee_salary")
    private Double employeeSalary;

    @NotNull
    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_address")
    private String employeeAddress;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;



}
