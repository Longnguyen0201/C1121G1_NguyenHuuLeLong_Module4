package com.codegym.repository.contract;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllByContract_ContractId(Integer id);
}
