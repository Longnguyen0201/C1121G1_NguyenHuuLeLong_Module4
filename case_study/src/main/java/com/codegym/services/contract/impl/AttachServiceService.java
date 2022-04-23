package com.codegym.services.contract.impl;

import com.codegym.model.contract.AttachService;
import com.codegym.repository.contract.IAttachServiceRepository;
import com.codegym.services.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
