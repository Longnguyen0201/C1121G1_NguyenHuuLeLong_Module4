package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
    @GetMapping(value = {"","/home"})
    public ModelAndView showMainPage(){
        return new ModelAndView("/home");
    }

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage(){
        return new ModelAndView("/login");
    }

    @GetMapping(value = "/error-403")
    public ModelAndView showErrorPage(){
        return new ModelAndView("/403Page");
    }

}
