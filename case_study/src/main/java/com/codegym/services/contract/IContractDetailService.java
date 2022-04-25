package com.codegym.services.contract;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    List<ContractDetail> findbyContractId(Integer id);
}
