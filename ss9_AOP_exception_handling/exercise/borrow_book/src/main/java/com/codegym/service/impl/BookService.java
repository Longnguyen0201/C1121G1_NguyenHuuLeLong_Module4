package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllBook(Pageable pageable) {
        return iBookRepository.findAll(pageable);

    }

    @Override
    public Optional<Book> findById(Integer bookId) {
        return iBookRepository.findById(bookId);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

}
