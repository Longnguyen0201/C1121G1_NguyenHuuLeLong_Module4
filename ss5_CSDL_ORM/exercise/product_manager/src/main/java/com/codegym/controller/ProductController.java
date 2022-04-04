package com.codegym.controller;

import com.codegym.models.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/products", ""})
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = iProductService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productObject", new Product());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    private ModelAndView saveProduct(@ModelAttribute("productObject") Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        iProductService.saveProduct(product);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = iProductService.findById(id);
        modelAndView.addObject("productObject", product);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateProduct(@ModelAttribute("productObject") Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        iProductService.updateProduct(product);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = iProductService.findById(id);
        modelAndView.addObject("productObject", product);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("productObject") Product product, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        iProductService.removeProduct(product);
        redirectAttributes.addFlashAttribute("massage", "Remove product successfully");
        return modelAndView;
    }

    @PostMapping(value = "/view/{id}")
    public ModelAndView viewProduct(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        Product product = iProductService.findById(id);
        modelAndView.addObject("productObject", product);
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "search") String searchName) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> list = iProductService.searchByName(searchName);
        modelAndView.addObject("products", list);
        return modelAndView;
    }
}
