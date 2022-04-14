package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"", "/list"})
    public ResponseEntity<Iterable<Blog>> showListBlog() {
        Iterable<Blog> blogList = iBlogService.findAll();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping(value = "/category")
    public ResponseEntity<Iterable<Category>> showListCategory(){
        Iterable<Category> categories = iCategoryService.findAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}")
    public ResponseEntity<Optional<Blog>> showBlog(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/search/{keyword}")
    public ResponseEntity<Iterable<Blog>> SearchBlogByCategory (@PathVariable String keyword){
        Iterable<Blog> blog = iBlogService.findBlogByCategory(keyword);
        if (blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
