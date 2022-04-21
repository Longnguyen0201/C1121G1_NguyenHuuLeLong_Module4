package com.codegym.services.service.impl;

import com.codegym.model.employee.Position;
import com.codegym.model.service.ServiceType;
import com.codegym.repository.service.IServiceTypeRepository;
import com.codegym.services.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
