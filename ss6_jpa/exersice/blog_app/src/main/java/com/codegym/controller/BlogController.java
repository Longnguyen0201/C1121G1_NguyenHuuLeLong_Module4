package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = {"/blog", ""})
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("blog");
        List<Blog> blogList = iBlogService.findAll();
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping(value = "create")
    public ModelAndView showformCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
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
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
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
    public ModelAndView deleteBlog(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
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
    public ModelAndView showBlog(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("blogObject", blog);
        return modelAndView;
    }
}
