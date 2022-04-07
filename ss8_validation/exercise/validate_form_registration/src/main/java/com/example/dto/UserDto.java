package com.example.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;
    @NotEmpty (message = "Please input name!")
    @Pattern(regexp = "(^$|[A-Za-z ]{1,45})", message = "Name must be from 5 -45 character")
    private String firstName;
    @NotEmpty (message = "Please input name!")
    @Pattern(regexp = "(^$|[A-Za-z ]{1,45})",message = "Name must be from 5 -45 character")
    private String lastName;
    private String phoneNumber;
    @Min(value = 18 , message = "Age must be than 18")
    private Integer age;
    @Email
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String numberPhone = userDto.getPhoneNumber();
        if (numberPhone.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty", "Phone Number not empty.");
        }else if (numberPhone.length()>11 || numberPhone.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length","length form 10 to 11.");
        }else if (!numberPhone.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith","Phone Number start with 0.");
        }else if (!numberPhone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches","Phone Number only include number.");
        }
    }
}
