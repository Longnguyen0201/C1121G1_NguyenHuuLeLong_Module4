package com.codegym.services.service.impl;

import com.codegym.model.service.RentType;
import com.codegym.repository.service.IRentTypeRepository;
import com.codegym.services.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;


    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
