package com.codegym.services.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllPaing(Pageable pageable);

    void save(Customer customer);

//    Optional<Customer> findById(Integer id);

    void remove(Integer idDelete);

    Customer findById(Integer id);

    Page<Customer> findAllPaingSearch(Pageable pageable, String keyword);
}
