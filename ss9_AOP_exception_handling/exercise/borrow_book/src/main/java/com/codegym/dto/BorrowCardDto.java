package com.codegym.dto;

import com.codegym.model.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowCardDto implements Validator {
    private String borrowBookId;
    private String status;
    @NotEmpty (message = "Vui lòng nhập ngày mượn sách !")
    private String startDate;
    @NotEmpty (message = "Vui lòng nhập ngày trả sách !")
    private String endDate;
    private Book book;
    @Valid
    private BorrowerDto borrower;

    public BorrowCardDto() {
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

    public BorrowerDto getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerDto borrower) {
        this.borrower = borrower;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowCardDto borrowCardDto = (BorrowCardDto) target;
        LocalDate dateCurrent = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateStart = LocalDate.parse(borrowCardDto.getStartDate(),formatterDate);
        LocalDate dateEnd = LocalDate.parse(borrowCardDto.getEndDate(),formatterDate);

        if (dateStart.isBefore(dateCurrent)){
            errors.rejectValue("startDate","deposit.dateStart","Ngày mượn sách  phải sau ngày hiện tại,Vui lòng nhập lại");
        }
//        if (dateEnd.isBefore(dateCurrent)){
//            errors.rejectValue("endDate","deposit.dateEnd","Ngày trả sách phải sau ngày hiện tại,Vui lòng nhập lại");
//        }
    }
}
