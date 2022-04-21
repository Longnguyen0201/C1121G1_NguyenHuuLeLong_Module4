package com.codegym.services.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findAllPaing(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer idDelete) {
        iCustomerRepository.deleteById(idDelete);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllPaingSearch(Pageable pageable, String keyword) {
        return iCustomerRepository.findAllByCustomerNameContaining(pageable,keyword);
    }

}
