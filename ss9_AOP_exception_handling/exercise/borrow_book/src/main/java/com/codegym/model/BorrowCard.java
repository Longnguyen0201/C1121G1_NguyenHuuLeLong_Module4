package com.codegym.model;

import javax.persistence.*;

@Entity
public class BorrowCard {
    @Id
    @Column(name = "borrow_book_id")
    private String borrowBookId;
    private String status;
    @Column(name = "start_date", columnDefinition = "date")
    private String startDate;
    @Column(name = "end_date", columnDefinition = "date")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrowerId", referencedColumnName = "borrowerId")
    private Borrower borrower;


    public BorrowCard() {
    }

    public String getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(String borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}



