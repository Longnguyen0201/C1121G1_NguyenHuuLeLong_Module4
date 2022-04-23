package com.codegym.services.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
     Page<Contract> findAllPaingSearch(Pageable pageable, String keywordValue);

    void save(Contract contract);

    Contract findById(Integer id);
}
