package com.codegym.repository.service;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String keyword);
}
