package com.codegym.repository;

import com.codegym.model.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCardRepository extends JpaRepository<BorrowCard,String> {
}
