package com.example.controller;

import com.example.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    private ICurrencyService currencyService;


    @GetMapping("/currency")
    public String showForm() {
        return "currency";
    }
    @PostMapping ("/conversion")
    public String conversionCurrency(@RequestParam (name = "usd") Double usd,
                                     @RequestParam(name = "rate") Double rate, Model model){
        Double vnd = this.currencyService.conversion(usd,rate);
        model.addAttribute("vnd", vnd);
        model.addAttribute("message", "Số tiền chuyển đổi (VND): ");
        return "currency";
    }
}
