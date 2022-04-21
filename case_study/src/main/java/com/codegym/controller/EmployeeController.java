package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.services.employee.IDivisionService;
import com.codegym.services.employee.IEducationDegreeService;
import com.codegym.services.employee.IEmployeeService;
import com.codegym.services.employee.IPositionService;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionservice;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return iPositionservice.findAll();
    }
    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> educationDegreeList() {
        return iEducationDegreeService.findAll();
    }
    @ModelAttribute("divisionList")
    public List<Division> divisionList() {
        return iDivisionService.findAll();
    }



    @GetMapping(value = {"", "/list"})
    public String showListEmployee(@PageableDefault(value = 2) Pageable pageable,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   ModelMap modelMap) {
        String keywordValue = keyword.orElse("");
        Page<Employee> employeePage = iEmployeeService.findAllPaingSearch(pageable,keywordValue);
        modelMap.put("keyword",keywordValue);
        modelMap.put("employeePageList",employeePage);
        return "/employee/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }






}
