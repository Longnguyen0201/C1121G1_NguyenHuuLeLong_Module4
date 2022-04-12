package com.codegym.dto;

import com.codegym.model.BorrowCard;

import javax.persistence.OneToMany;
import java.util.Set;

public class BookDto {

    private Integer bookId;
    private String nameBook;
    private String author;
    private Integer quantity;
    private String describee;



    public BookDto() {
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

    public String getDescribee() {
        return describee;
    }

    public void setDescribee(String describee) {
        this.describee = describee;
    }
}
