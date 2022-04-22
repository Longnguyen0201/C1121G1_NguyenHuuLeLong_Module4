package com.codegym.services.employee;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllPaingSearch(Pageable pageable, String keywordValue);

    void save(Employee employee);

    Employee findById(Integer id);

    void remove(Integer idDelete);
}
