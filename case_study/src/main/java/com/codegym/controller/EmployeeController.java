package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.employee.user.AppUser;
import com.codegym.services.employee.IDivisionService;
import com.codegym.services.employee.IEducationDegreeService;
import com.codegym.services.employee.IEmployeeService;
import com.codegym.services.employee.IPositionService;
import com.codegym.services.user.IAppUserService;
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
    @Autowired
    private IAppUserService iUserService;

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
    public String showListEmployee(@PageableDefault(value = 5) Pageable pageable,
                                   @RequestParam("keyword") Optional<String> keyword,
                                   ModelMap modelMap) {
        String keywordValue = keyword.orElse("");
        Page<Employee> employeePage = iEmployeeService.findAllPaingSearch(pageable, keywordValue);
        modelMap.put("keyword", keywordValue);
        modelMap.put("employeePageList", employeePage);
        return "/employee/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreateEmployee() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView addEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/employee/create");
            return modelAndView;
        }
        Position position = employeeDto.getPosition();
        EducationDegree educationDegree = employeeDto.getEducationDegree();
        Division division = employeeDto.getDivision();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        AppUser user = new AppUser(employeeDto.getEmployeeEmail(), "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        iUserService.save(user);
        employee.setPosition(position);
        employee.setEducationDegree(educationDegree);
        employee.setDivision(division);
        employee.setUser(user);
        iEmployeeService.save(employee);
        modelAndView = new ModelAndView("redirect:/employees");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setEducationDegree(employee.getEducationDegree());
        employeeDto.setDivision(employee.getDivision());
        employeeDto.setUser(employee.getUser());
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public ModelAndView udateEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/employee/edit");
            return modelAndView;
        }
        Position position = employeeDto.getPosition();
        EducationDegree educationDegree = employeeDto.getEducationDegree();
        Division division = employeeDto.getDivision();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        AppUser user = new AppUser(employeeDto.getEmployeeEmail(), "123456");
        iUserService.save(user);
        employee.setPosition(position);
        employee.setEducationDegree(educationDegree);
        employee.setDivision(division);
        employee.setUser(user);
        iEmployeeService.save(employee);
        modelAndView = new ModelAndView("redirect:/employees");
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer idDelete) {
        iEmployeeService.remove(idDelete);
        return "redirect:/customers";
    }

}
