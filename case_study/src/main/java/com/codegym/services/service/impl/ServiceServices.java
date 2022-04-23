package com.codegym.services.service.impl;

import com.codegym.repository.service.IServiceRepository;
import com.codegym.services.service.IServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServices implements IServiceServices {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<com.codegym.model.service.Service> findAllPaingSearch(Pageable pageable, String keywordValue) {
        return iServiceRepository.findAllByServiceNameContaining(pageable, keywordValue);
    }

    @Override
    public void save(com.codegym.model.service.Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public List<com.codegym.model.service.Service> findAll() {
        return iServiceRepository.findAll();
    }
}
