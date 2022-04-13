package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, @RequestParam("action") String action){
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent()){
            model.addAttribute("product",product.get());
            return "/view";
        }else {
            return "/error.404";
        }
    }

    @GetMapping("/remove/{id}")
    public  String remove(@PathVariable Long id,@SessionAttribute Cart cart){
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent()){
            cart.remove(product.get());
            return "redirect:/shopping-cart";
        }else {
            return "/error.404";
        }
    }
    @GetMapping("/buyCart")
    public String buyCart(@SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes){
        cart.buy();
        redirectAttributes.addFlashAttribute("message","Buy success");
        return "redirect:/shop";
    }





}
