package com.codegym.services.employee.impl;

import com.codegym.model.employee.Division;
import com.codegym.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDivisionService implements com.codegym.services.employee.IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
