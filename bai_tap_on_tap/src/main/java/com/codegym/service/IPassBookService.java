package com.codegym.service;

import com.codegym.model.PassBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPassBookService {
    List<PassBook> findAll();

    void save(PassBook passBook);

    PassBook findById(Long id);

    void remove(Long id);

    Page<PassBook> findByName(String keyword, Pageable pageable);
}
