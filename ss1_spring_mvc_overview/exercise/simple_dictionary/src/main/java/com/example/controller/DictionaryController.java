package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping({"/index", ""})
    public String showForm() {
        return "/index";
    }

    @PostMapping("/dictionary")
    public String translation(@RequestParam(name = "search") String search, Model model) {
        String result = this.dictionaryService.translation(search);
        model.addAttribute("result", result);
        return "/index";
    }

}
