package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = {"/add","/"})
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("userDto",new UserDto());
        return modelAndView;
    }
    @PostMapping(value = "/create")
    public ModelAndView addUser (@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult){

        ModelAndView modelAndView = null;
        userDto.validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            modelAndView = new ModelAndView("/index");
            modelAndView.addObject("userDto",userDto);
            return modelAndView;
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);

        modelAndView = new ModelAndView("/result");
        modelAndView.addObject("userObject",user);
        return modelAndView;
    }

}
