package com.codegym.model.employee.user;

import com.codegym.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "User_Id", nullable = false)
    private Integer userId;
    private String username;
    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;
    @OneToMany(mappedBy = "user")
    private Set<UserRole> useRoles;

    public User() {
    }

    public User(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
