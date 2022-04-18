package com.codegym.controller;

import com.codegym.dto.CustomerDTO;
import com.codegym.dto.PassBookDTO;
import com.codegym.model.Customer;
import com.codegym.model.PassBook;
import com.codegym.service.ICustomerService;
import com.codegym.service.IPassBookService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class PassBookController {

    @Autowired
    IPassBookService iPassBookService;

    @Autowired
    ICustomerService iCustomerService;

    @ModelAttribute("periodList")
    public List<Integer> period() {
        return Arrays.asList(3, 6, 9, 12, 18, 24);
    }

//    @GetMapping(value = {"/list", ""})
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        List<PassBook> passBooks = iPassBookService.findAll();
//        modelAndView.addObject("passbookList", passBooks);
//        return modelAndView;
//    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("passbookDto", new PassBookDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView addPassbook(@Valid @ModelAttribute("passbookDto") PassBookDTO passBookDTO,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView;
        passBookDTO.validate(passBookDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("create");
//            modelAndView.addObject("passbookDto",passBookDTO);
            return modelAndView;
        }
        Customer customer = new Customer(passBookDTO.getCustomer().getCode(), passBookDTO.getCustomer().getName());
        PassBook passBook = new PassBook();
        BeanUtils.copyProperties(passBookDTO, passBook);
        passBook.setCustomer(customer);
        iPassBookService.save(passBook);
        modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        PassBook passBook = iPassBookService.findById(id);

        CustomerDTO customerDTO = new CustomerDTO(passBook.getCustomer().getId(), passBook.getCustomer().getCode(),
                passBook.getCustomer().getName());
        PassBookDTO passBookDTO = new PassBookDTO();
        BeanUtils.copyProperties(passBook, passBookDTO);
        passBookDTO.setCustomer(customerDTO);
        modelAndView.addObject("passBookDTO", passBookDTO);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editBlog(@ModelAttribute("passBookDTO") PassBookDTO passBookDTO, BindingResult bindingResult) {
        ModelAndView modelAndView;
        passBookDTO.validate(passBookDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/edit");
//            modelAndView.addObject("passbookDto", passBookDTO);
            return modelAndView;
        }
        PassBook passBook = new PassBook();
        BeanUtils.copyProperties(passBookDTO, passBook);
        Customer customer = new Customer(passBookDTO.getCustomer().getId(),
                passBookDTO.getCustomer().getCode(), passBookDTO.getCustomer().getName());
        passBook.setCustomer(customer);
        iPassBookService.save(passBook);
        modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }


    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        PassBook passBook = iPassBookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("passBook", passBook);
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("passBook") PassBook passBook) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        iPassBookService.remove(passBook.getId());
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public String search(@RequestParam("keyword") Optional<String> keywordValue,
                         @PageableDefault(value = 3) Pageable pageable,
                         RedirectAttributes redirectAttributes,
                         ModelMap modelMap) {
        String keyword = keywordValue.orElse("");
        Page<PassBook> list = iPassBookService.findByName(keyword, pageable);
//        if (keyword.equals("") || list.isEmpty()) {
//            redirectAttributes.addFlashAttribute("keyword", keyword);
//            redirectAttributes.addFlashAttribute("message", "Passbook not found");
//            return "redirect:/list";
//        } else {
        modelMap.put("keyword", keyword);
        modelMap.put("passbookList", list);
        return "/list";
//        }
    }
}
