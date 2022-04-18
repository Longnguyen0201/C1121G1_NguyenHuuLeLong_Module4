package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

  @Autowired
  private ICustomerService iCustomerService;

    @GetMapping(value = "/list")
    public ModelAndView showFormList(){
ModelAndView modelAndView = new ModelAndView("/index");
        List<Customer> customerList = iCustomerService.findAll();
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }
}
