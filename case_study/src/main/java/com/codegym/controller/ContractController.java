package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.services.contract.IContractService;
import com.codegym.services.customer.ICustomerService;
import com.codegym.services.employee.IEmployeeService;
import com.codegym.services.service.IServiceServices;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IServiceServices iServiceServices;

    @GetMapping(value = {"", "/list"})
    public String showListContracts(@PageableDefault(value = 2) Pageable pageable,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   ModelMap modelMap) {
        String keywordValue = keyword.orElse("");
        Page<Contract> contractPage = iContractService.findAllPaingSearch(pageable,keywordValue);
        modelMap.put("keyword",keywordValue);
        modelMap.put("contractPageList",contractPage);
        return "/contract/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreateContract() {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        List<Customer> customerList =iCustomerService.findAll();
        List<Employee> employeeList =iEmployeeService.findAll();
        List<Service> serviceList =iServiceServices.findAll();
        modelAndView.addObject("contractDto", new ContractDto());
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("employeeList",employeeList);
        modelAndView.addObject("serviceList",serviceList);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView addContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        contractDto.validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contract/create");
            return modelAndView;
        }

        Customer customer = contractDto.getCustomer();
        Employee employee = contractDto.getEmployee();
        Service service = contractDto.getService();
        Contract contract =new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setCustomer(customer);
        contract.setEmployee(employee);
        contract.setService(service);
        iContractService.save(contract);
        modelAndView = new ModelAndView("redirect:/contracts");
        return modelAndView;
    }

}
