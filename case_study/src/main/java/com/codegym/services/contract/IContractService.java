package com.codegym.services.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
     Page<Contract> findAllPaingSearch(Pageable pageable, String keywordValue);

    void save(Contract contract);
}
