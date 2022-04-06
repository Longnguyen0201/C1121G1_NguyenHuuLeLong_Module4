package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/category")
    public ModelAndView listProvinces() {
        Iterable<Category> categories = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categorys", categories);
        return modelAndView;
    }
    @GetMapping(value = "/create-category")
    public ModelAndView showformCreate() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categoryObject", new Category());
        return modelAndView;
    }
}

