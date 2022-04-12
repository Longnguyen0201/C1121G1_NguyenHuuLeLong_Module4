package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAllBook(Pageable pageable);

    Optional<Book> findById(Integer bookId);


    void save(Book book);
}
