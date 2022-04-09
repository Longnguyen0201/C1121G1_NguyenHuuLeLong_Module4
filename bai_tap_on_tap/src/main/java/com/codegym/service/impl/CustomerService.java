package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repositoty.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
