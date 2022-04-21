package com.codegym.services.service;

import com.codegym.model.employee.Position;
import com.codegym.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
