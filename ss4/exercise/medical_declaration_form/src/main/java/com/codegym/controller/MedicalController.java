package com.codegym.controller;

import com.codegym.models.MedicalDeclaration;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    IMedicalService iMedicalService;

    @GetMapping(value ="/create")
    public ModelAndView showForm (){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("medicalDeclaration",new MedicalDeclaration());
        String[] gender = new String[]{"Nam", "Nữ", "Khác"};
        String[] vehicle = new String[]{"Tàu bay","Tàu thuyền","Ô tô","Khác"};
        modelAndView.addObject("gender",gender);
        modelAndView.addObject("vehicle",vehicle);
        return modelAndView;
    }
    @PostMapping(value = "/save")
    public ModelAndView createMedical(@ModelAttribute ("medicalDeclaration") MedicalDeclaration medicalDeclaration){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        iMedicalService.save(medicalDeclaration);
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public ModelAndView showList (){
        ModelAndView modelAndView = new ModelAndView("list");
        List<MedicalDeclaration> medicalDeclarationList = iMedicalService.findAll();
        modelAndView.addObject("medicalDeclarationList",medicalDeclarationList);
        return modelAndView;
    }



}
