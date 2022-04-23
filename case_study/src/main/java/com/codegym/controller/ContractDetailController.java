package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.services.contract.IAttachServiceService;
import com.codegym.services.contract.IContractDetailService;
import com.codegym.services.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;

@Controller
@RequestMapping(value = "contractDetails")
public class ContractDetailController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/addContractDetail/{id}")
    public ModelAndView showAddForm(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/contract/contractDetail");
        Contract contract = iContractService.findById(id);
        List<AttachService> attachServiceList = iAttachServiceService.findAll();
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(contract);
        modelAndView.addObject("contractDetailDto", contractDetailDto);
        modelAndView.addObject("contractObj",contract);
        modelAndView.addObject("attachServiceList",attachServiceList);
        return modelAndView;
    }
    @PostMapping(value = "save")
    public ModelAndView save(@Valid @ModelAttribute ("contractDetailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult){
        ModelAndView modelAndView ;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/contract/contractDetail");
            return modelAndView;
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        iContractDetailService.save(contractDetail);
        modelAndView = new ModelAndView("redirect:/contracts");
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Integer id) {
        ModelAndView modelAndView =new ModelAndView("/contract/view");
        ContractDetail contractDetail = iContractDetailService.findbyContractId(id);
        modelAndView.addObject("contractDetailObj",contractDetail);
        return modelAndView;
    }


}
