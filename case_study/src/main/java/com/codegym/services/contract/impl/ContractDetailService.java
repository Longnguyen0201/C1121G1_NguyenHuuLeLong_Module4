package com.codegym.services.contract.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.services.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findbyContractId(Integer id) {
        return iContractDetailRepository.findByContract_ContractId(id);
    }
}
