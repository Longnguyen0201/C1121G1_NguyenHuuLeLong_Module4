package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.services.contract.IContractDetailService;
import com.codegym.services.contract.IContractService;
import com.codegym.services.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private com.codegym.service.customer.ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeObj")
    public List<CustomerType> customerType() {
        return iCustomerTypeService.findAll();
    }

    @ModelAttribute("genders")
    public List<Integer> gender() {
        return Arrays.asList(1, 2, 3);
    }


    @GetMapping(value = {"", "/list"})
    public String showListCustomer(@PageableDefault(value = 2) Pageable pageable,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   ModelMap modelMap) {
        String keywordValue = keyword.orElse("");
        Page<Customer> customerPage = iCustomerService.findAllPaingSearch(pageable,keywordValue);
        modelMap.put("keyword",keywordValue);
        modelMap.put("customerPageList",customerPage);
        return "/customer/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView addCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/customer/create");
            return modelAndView;
        }
        CustomerType customerType = new CustomerType(customerDto.getCustomerType().getCustomerTypeId(),
                customerDto.getCustomerType().getCustomerTypeName());
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        customerDto.setCustomerType(customer.getCustomerType());
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editCustomer(@ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        ModelAndView modelAndView;
        customerDto.validate(customerDto, bindingResult);
                if (bindingResult.hasFieldErrors()) {
                    modelAndView = new ModelAndView("/customer/edit");
                    return modelAndView;
                }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerDto.getCustomerType());
        iCustomerService.save(customer);
        modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }


    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer idDelete) {
        iCustomerService.remove(idDelete);
        return "redirect:/customers";
    }




}
