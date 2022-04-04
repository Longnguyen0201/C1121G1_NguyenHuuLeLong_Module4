package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.ICustomerRepository;
import cg.wbd.grandemonstration.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return iCustomerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return iCustomerRepository.save(customers);
    }

    @Override
    public boolean exists(Long id) {
        return iCustomerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return iCustomerRepository.findAll(ids);
    }

    @Override
    public long count() {
        return iCustomerRepository.count();
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        iCustomerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        iCustomerRepository.deleteAll();
    }
}
