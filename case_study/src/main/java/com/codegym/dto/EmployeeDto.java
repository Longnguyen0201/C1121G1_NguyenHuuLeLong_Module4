package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import com.codegym.model.employee.user.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class EmployeeDto implements Validator {

    private Integer employeeId;
    @NotEmpty(message = "Please,Enter employee name! ")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)",message = "Name without special characters and numbers!")
    private String employeeName;
    @NotEmpty(message = "Please,Enter birthday! ")
    private String employeeBirthday;
    @NotEmpty(message = "Please,Enter employee ID card! ")
    @Pattern(regexp = "(^$|^(\\d{9})|(\\d{12})$)", message = "ID card must consist of 9 or 12 digits")
    private String employeeIdCard;
    @NotNull
    @Min(0)
    private Double employeeSalary;
    @NotEmpty
    @Pattern(regexp = "(^$|^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$)", message = "Wrong format input phone " +
            "(ex: 090xxxxxxx |091xxxxxxx | (84)+90xxxxxxx |(84)+91xxxxxxx ) ")
    private String employeePhone;
    @NotEmpty
    @Pattern(regexp = "^$|^[a-z][a-z0-9_\\.]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$",message = "Wrong format input email")
    private String employeeEmail;
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;
    private Set<Contract> contracts;

    public EmployeeDto()  {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
