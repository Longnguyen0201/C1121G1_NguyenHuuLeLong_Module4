package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService extends IGeneralService<Blog>{

    Page<Blog> findBlogByName(String keyWordValue, Pageable pageable);


    Iterable<Blog> findBlogByCategory(String keyword);

    Iterable<Blog> findByAuthor(String keyword);

    Page<Blog> findAllPage(Pageable pageable);
}
