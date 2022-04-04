package com.codegym.service.impl;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepository;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService implements ICommentService {

    @Autowired
    ICommentRepository iCommentRepository;

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return iCommentRepository.findById(id);
    }
}
