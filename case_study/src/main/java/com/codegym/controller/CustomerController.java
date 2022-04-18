package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "customers")
    public ResponseEntity<Page<Customer>> showListCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customerPage = iCustomerService.findAllPaing(pageable);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

}
