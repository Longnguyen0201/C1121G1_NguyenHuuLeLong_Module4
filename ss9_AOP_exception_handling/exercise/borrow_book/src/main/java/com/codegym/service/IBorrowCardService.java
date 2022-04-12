package com.codegym.service;

import com.codegym.model.BorrowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBorrowCardService {
    void save(BorrowCard borrowCard);


    Page<BorrowCard> findAll(Pageable pageable);

  BorrowCard findById(String borrowCardId);

    void remove(Optional<BorrowCard> borrowCard);
}
