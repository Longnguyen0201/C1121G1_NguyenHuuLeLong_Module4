package com.codegym.services.service;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceServices {
    Page<Service> findAllPaingSearch(Pageable pageable, String keywordValue);

    void save(Service service);

    List<Service> findAll();
}
