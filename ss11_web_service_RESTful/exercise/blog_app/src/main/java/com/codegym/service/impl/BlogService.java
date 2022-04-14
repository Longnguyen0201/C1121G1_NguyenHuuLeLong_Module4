package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Iterable<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blog.setDateOfWriting(String.valueOf(LocalDate.now()));
       this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByName(String keyWordValue, Pageable pageable) {
        return iBlogRepository.findAllByAuthorContainingOrderByDateOfWriting(keyWordValue,pageable);
    }

    @Override
    public Iterable<Blog> findBlogByCategory(String keyword) {
        return iBlogRepository.findByNameCategory(keyword);
    }

}
