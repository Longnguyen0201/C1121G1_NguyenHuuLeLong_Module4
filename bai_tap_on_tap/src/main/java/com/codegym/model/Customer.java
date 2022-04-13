package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer<set> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<PassBook> passBooks;

    public Customer() {
    }

    public Customer(Long id, String code, String name, Set<PassBook> passBooks) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.passBooks = passBooks;
    }

    public Customer(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Customer(Long id, String code, String name) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PassBook> getPassBooks() {
        return passBooks;
    }

    public void setPassBooks(Set<PassBook> passBooks) {
        this.passBooks = passBooks;
    }
}
