package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @GetMapping(value = {"/blog"})
    public ModelAndView showList(@PageableDefault(value = 2)Pageable pageable, @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("/blog/blogList");
        String  keyWordValue =keyword.orElse("");
        Page <Blog> blogList = iBlogService.findBlogByName(keyWordValue,pageable);
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("keyWordValue",keyWordValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showformCreate() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blogObject", new Blog());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    private ModelAndView saveProduct(@ModelAttribute("blogObject") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        iBlogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blogObject", blog);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editBlog(@ModelAttribute("blogObject") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        iBlogService.save(blog);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blogObject", blog);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("blogObject") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        iBlogService.remove(blog.getId());
        return modelAndView;
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView showBlog(@PathVariable Long id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blogObject", blog);
        return modelAndView;
    }
}
