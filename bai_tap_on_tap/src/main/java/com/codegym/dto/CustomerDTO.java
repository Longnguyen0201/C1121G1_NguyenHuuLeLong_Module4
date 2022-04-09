package com.codegym.dto;

import com.codegym.model.PassBook;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDTO {
    private Long id;
    @NotEmpty(message = "Please input Code!")
    private String code;
    @NotEmpty(message = "Please input name!")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)",message = "Name cannot contain letters and numbers")
    private String name;


    public CustomerDTO(String code, String name) {
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
