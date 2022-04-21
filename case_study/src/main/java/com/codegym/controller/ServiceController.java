package com.codegym.controller;

import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import com.codegym.services.service.IRentTypeService;
import com.codegym.services.service.IServiceServices;
import com.codegym.services.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/services")
public class ServiceController {
    @Autowired
    private IServiceServices iServiceServices;

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return iServiceTypeService.findAll();
    }
    @Autowired
    private IRentTypeService iRentTypeService;

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
}
