package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PassBookDTO implements Validator {


    private Long id;
    @NotEmpty (message = "Vui lòng nhập ngày gửi tiền !")
    private String startDay;

    private Integer period;
    @NotNull(message = "Vui lòng nhập số  tiền gửi!")
    @Min(value = 30000000, message = "amount must be greater than 30.000.000 VNĐ")
    private Double moneySave;
    @Valid
    private CustomerDTO customer;

    public PassBookDTO() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getMoneySave() {
        return moneySave;
    }

    public void setMoneySave(Double moneySave) {
        this.moneySave = moneySave;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PassBookDTO passBookDTO = (PassBookDTO) target;
        LocalDate dateCurrent = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateInput = LocalDate.parse(passBookDTO.getStartDay(),formatterDate);
        if (dateInput.isBefore(dateCurrent)){
            errors.rejectValue("startDay","deposit.date","Ngày gửi tiền phải sau ngày hiện tại,Vui lòng nhập lại");
        }

    }

}
