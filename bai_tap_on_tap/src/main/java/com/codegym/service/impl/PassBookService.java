package com.codegym.service.impl;

import com.codegym.model.PassBook;
import com.codegym.repositoty.IPassBookRepository;
import com.codegym.service.IPassBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassBookService implements IPassBookService {
    @Autowired
    IPassBookRepository iPassBookRepository;

    @Override
    public List<PassBook> findAll() {
        return iPassBookRepository.findAll();
    }

    @Override
    public void save(PassBook passBook) {
        iPassBookRepository.save(passBook);
    }

    @Override
    public PassBook findById(Long id) {
        return iPassBookRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        iPassBookRepository.deleteById(id);
    }

    @Override
    public List<PassBook> findByName(String keyword) {
        return iPassBookRepository.findAllByCustomer_NameContaining(keyword);
    }
}
