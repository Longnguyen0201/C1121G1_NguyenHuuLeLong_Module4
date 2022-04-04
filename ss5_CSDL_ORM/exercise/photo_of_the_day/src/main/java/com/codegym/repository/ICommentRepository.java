package com.codegym.repository;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();

    void save(Comment comment);

    Comment findById(Integer id);
}
