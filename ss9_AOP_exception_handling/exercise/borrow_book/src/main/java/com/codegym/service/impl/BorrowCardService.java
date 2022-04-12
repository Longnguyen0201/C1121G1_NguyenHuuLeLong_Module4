package com.codegym.service.impl;

import com.codegym.model.BorrowCard;
import com.codegym.repository.IBorrowCardRepository;
import com.codegym.service.IBorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowCardService implements IBorrowCardService {
    @Autowired
    IBorrowCardRepository iBorrowCardRepository;
    @Override
    public void save(BorrowCard borrowCard) {
        iBorrowCardRepository.save(borrowCard);
    }

    @Override
    public Page<BorrowCard> findAll(Pageable pageable) {
        return iBorrowCardRepository.findAll(pageable);
    }

    @Override
    public BorrowCard findById(String borrowCardId) {
        return iBorrowCardRepository.findById(borrowCardId).orElse(null);
    }

    @Override
    public void remove(Optional<BorrowCard> borrowCard) {
       String id =  borrowCard.orElse(null).getBorrowBookId();
       iBorrowCardRepository.deleteById(id);
    }
}
