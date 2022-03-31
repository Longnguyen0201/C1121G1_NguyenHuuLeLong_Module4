package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class emailBoxController {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        String[] languageList = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject("pageSizeList",pageSizeList);
        modelAndView.addObject("mail",new Email());
        return modelAndView;
    }
    @PostMapping(value = "/save")
    public String saveConfig(@ModelAttribute("mail") Email email, Model model){
        model.addAttribute("email",email);
        return "show";
    }
    @PostMapping(value = "/edit")
    public ModelAndView editConfig (@ModelAttribute("mail") Email email){
        ModelAndView modelAndView = new ModelAndView("edit");
        String[] languageList = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject("pageSizeList",pageSizeList);
        modelAndView.addObject("mail",email);
        return modelAndView;
    }



}
