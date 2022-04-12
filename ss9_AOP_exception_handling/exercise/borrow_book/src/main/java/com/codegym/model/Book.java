package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "book_id")
    private Integer bookId;
    private String nameBook;
    private String author;
    private Integer quantity;
    private String describee;

    @OneToMany(mappedBy = "book")
    private Set<BorrowCard> borrowCard;


    public Book() {
    }

    public Book(Integer bookId, String nameBook, String author, Integer quantity, String describee) {
        this.bookId = bookId;
        this.nameBook = nameBook;
        this.author = author;
        this.quantity = quantity;
        this.describee = describee;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describee;
    }

    public void setDescribe(String describe) {
        this.describee = describe;
    }

    public Set<BorrowCard> getBorrowCard() {
        return borrowCard;
    }

    public void setBorrowCard(Set<BorrowCard> borrowCard) {
        this.borrowCard = borrowCard;
    }
}
