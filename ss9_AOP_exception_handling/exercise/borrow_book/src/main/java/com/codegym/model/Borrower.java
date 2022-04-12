package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "borrower_id")
    private Integer borrowerId;
    private String name;

    @OneToMany(mappedBy = "borrower")
    private Set<BorrowCard> borrowCards;

    public Borrower(Integer borrowerId, String name) {
        this.borrowerId = borrowerId;
        this.name = name;
    }

    public Borrower() {

    }

    public Borrower(String name) {
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BorrowCard> getBorrowCards() {
        return borrowCards;
    }

    public void setBorrowCards(Set<BorrowCard> borrowCards) {
        this.borrowCards = borrowCards;
    }
}
