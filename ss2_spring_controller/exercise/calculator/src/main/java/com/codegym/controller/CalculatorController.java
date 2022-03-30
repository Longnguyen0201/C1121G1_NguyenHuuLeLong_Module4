package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    public ICalculatorService iCalculatorService;
    @GetMapping("/home")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/calculator")
    public ModelAndView calculator(@RequestParam(name = "number1") int number1,
                                   @RequestParam(name = "number2") int number2 ,
                                   @RequestParam(name = "operator") String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        int result = 0;
        if (operator.equals("+")) {
            result = iCalculatorService.addition(number1, number2);
        } else if (operator.equals("-")) {
            result = iCalculatorService.subtraction(number1, number2);
        } else if (operator.equals("*")) {
            result = iCalculatorService.multiplication(number1, number2);
        } else if (operator.equals("/")) {
            result = iCalculatorService.division(number1, number2);
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
