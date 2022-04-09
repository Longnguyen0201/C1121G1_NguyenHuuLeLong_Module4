package com.codegym.service;

import com.codegym.model.PassBook;

import java.util.List;

public interface IPassBookService {
    List<PassBook> findAll();

    void save(PassBook passBook);

    PassBook findById(Long id);

    void remove(Long id);

    List<PassBook> findByName(String keyword);
}
