package com.codegym.services.contract;

import com.codegym.model.contract.ContractDetail;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    ContractDetail findbyContractId(Integer id);
}
