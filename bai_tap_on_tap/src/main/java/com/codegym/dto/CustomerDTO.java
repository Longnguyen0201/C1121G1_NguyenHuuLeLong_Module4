package com.codegym.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
    private Long id;
    @NotEmpty(message = "Vui lòng nhập số  mã khách hàng! ")
    private String code;
    @NotEmpty(message = "Vui lòng nhập tên khách hàng!")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)",message = "Tên khách hàng không được có kí tự đặc biệt và số")
    private String name;


    public CustomerDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public CustomerDTO(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public CustomerDTO() {
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


}
