package com.codegym.services.service;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceServices {
    Page<Service> findAllPaingSearch(Pageable pageable, String keywordValue);
}
