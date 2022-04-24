package com.codegym.services.contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.services.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAllPaingSearch(Pageable pageable, String keywordValue) {
        return iContractRepository.findAllByCustomer_CustomerNameContaining(pageable,keywordValue);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
