package com.codegym.services.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.services.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<Employee> findAllPaingSearch(Pageable pageable, String keywordValue) {
        return iEmployeeRepository.findAllByEmployeeNameContaining(pageable,keywordValue);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer idDelete) {
        iEmployeeRepository.deleteById(idDelete);
    }
}
