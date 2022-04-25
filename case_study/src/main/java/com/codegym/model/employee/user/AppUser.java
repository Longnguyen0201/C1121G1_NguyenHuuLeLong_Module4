package com.codegym.model.employee.user;

import com.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;
    @OneToMany(mappedBy = "appUser")
    private Set<UserRole> useRoles;

    public AppUser() {
    }


    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUseRoles() {
        return useRoles;
    }

    public void setUseRoles(Set<UserRole> useRoles) {
        this.useRoles = useRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
