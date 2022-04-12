package com.codegym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BorrowerDto {

    private Integer borrowerId;
    @NotEmpty(message = "Vui lòng nhập tên người mượn!")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)",message = "Tên khách hàng không được có kí tự đặc biệt và số")
    private String name;



    public BorrowerDto() {
    }

    public BorrowerDto(String name) {
        this.name = name;
    }

    public BorrowerDto(Integer borrowerId, String name) {
        this.borrowerId = borrowerId;
        this.name = name;
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
}
