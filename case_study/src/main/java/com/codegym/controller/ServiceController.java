package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import com.codegym.services.service.IRentTypeService;
import com.codegym.services.service.IServiceServices;
import com.codegym.services.service.IServiceTypeService;
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
@RequestMapping(value = "/services")
public class ServiceController {
    @Autowired
    private IServiceServices iServiceServices;

    @Autowired
    private IServiceTypeService iServiceTypeService;


    @Autowired
    private IRentTypeService iRentTypeService;
    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return iServiceTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList() {
        return iRentTypeService.findAll();
    }


    @GetMapping(value = {"", "/list"})
    public String showListService(@PageableDefault(value = 2) Pageable pageable,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   ModelMap modelMap) {
        String keywordValue = keyword.orElse("");
        Page<Service> servicePage = iServiceServices.findAllPaingSearch(pageable,keywordValue);
        modelMap.put("keyword",keywordValue);
        modelMap.put("servicePageList",servicePage);
        return "/service/list";
    }
    @GetMapping(value = "/create")
    public ModelAndView showFormCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }
    @PostMapping(value = "/save")
    public ModelAndView addCustomer(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        serviceDto.validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/service/create");
            return modelAndView;
        }
        ServiceType serviceType = serviceDto.getServiceType();
        RentType rentType = serviceDto.getRentType();
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setRentType(rentType);
        service.setServiceType(serviceType);
        iServiceServices.save(service);
        modelAndView = new ModelAndView("redirect:/services");
        return modelAndView;
    }

}
